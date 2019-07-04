package user.manager.command.side.infraestructure.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import user.manager.command.side.domain.aggregate.model.user.User;
import user.manager.command.side.infraestructure.MqttGatewayTestConfig;
import user.manager.command.side.infraestructure.api.model.UserModel;
import user.manager.command.side.infraestructure.api.model.UsersModel;
import user.manager.command.side.infraestructure.config.UserCommandSideConfig;
import user.manager.command.side.infraestructure.enums.UserTypeEnum;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserCommandSideConfig.class, MqttGatewayTestConfig.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class UserControllerITest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private HttpHeaders headers = new HttpHeaders();

    @Test
    public void createPersonUser() {
        UserModel userModel = new UserModel();
        //grupoModel.setGrupoId();
        userModel.setSocialIdentifier("11111111-1");
        userModel.setFirstName("Bart");
        userModel.setLastName("Simpson");
        userModel.setUserType(UserTypeEnum.PERSON.getTypeId());

        HttpEntity<UserModel> entity = new HttpEntity<>(userModel, headers);
        ResponseEntity<UsersModel> response =
                restTemplate.exchange(String.format("http://localhost:%s/user-manager-command-side/api/command/user/create", port), HttpMethod.POST, entity, UsersModel.class);
        Assert.assertTrue(response.getStatusCode() == HttpStatus.OK);

        UsersModel usersModelResponse = response.getBody();
        Optional<UserModel> grupoModelResponse = usersModelResponse.getUsers().stream().findFirst();
        Assert.assertTrue(grupoModelResponse.isPresent()); //It's created
        Assert.assertTrue(grupoModelResponse.get().getSocialIdentifier().equals("11111111-1")); //It's created
        Assert.assertTrue(grupoModelResponse.get().getFirstName().equals("Bart")); //It's created
        Assert.assertTrue(grupoModelResponse.get().getLastName().equals("Simpson")); //It's created
    }

    @Test
    public void createGroupUser() {
        UserModel userModel = new UserModel();
        //grupoModel.setGrupoId();
        userModel.setSocialIdentifier("11111111-1");
        userModel.setGroupName("El bar de Moe");
        userModel.setUserType(UserTypeEnum.PARTY_GROUP.getTypeId());

        HttpEntity<UserModel> entity = new HttpEntity<>(userModel, headers);
        ResponseEntity<UsersModel> response =
                restTemplate.exchange(String.format("http://localhost:%s/user-manager-command-side/api/command/user/create", port), HttpMethod.POST, entity, UsersModel.class);
        Assert.assertTrue(response.getStatusCode() == HttpStatus.OK);

        UsersModel usersModelResponse = response.getBody();
        Optional<UserModel> grupoModelResponse = usersModelResponse.getUsers().stream().findFirst();
        Assert.assertTrue(grupoModelResponse.isPresent()); //It's created
        Assert.assertTrue(grupoModelResponse.get().getSocialIdentifier().equals("11111111-1")); //It's created
        Assert.assertTrue(grupoModelResponse.get().getGroupName().equals("El bar de Moe")); //It's created
    }
}
