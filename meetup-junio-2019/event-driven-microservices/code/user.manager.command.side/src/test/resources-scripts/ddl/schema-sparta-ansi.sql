-------------------------------------------------------------------------------------------------------------------
-- SEED DATA FOR TABLE PERSON COLUMN PARAMETRIC_ATT_TYPES
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE "PARAMETRIC_ATT_TYPES" (
  				"PAATTY_ID" VARCHAR(40), 
				"PAATTY_DSC" VARCHAR(512), 
				"PAATTY_FLG_WS" CHAR(1), 
				"PAATTY_NMR_VARIABLES" NUMERIC(38,0), 
				"PAATTY_VLR_FIFTH_LABEL" VARCHAR(30), 
				"PAATTY_VLR_FOURTH_LABEL" VARCHAR(30), 
				"PAATTY_VLR_THIRD_LABEL" VARCHAR(30), 
				"PAATTY_VLR_SECOND_LABEL" VARCHAR(30), 
				"PAATTY_VLR_KEY_LABEL" VARCHAR(30), 
				"PAATTY_FLG_ACTIVE" CHAR(1), 
				"PAATTY_NMR_KEY_LENGTH" NUMERIC(38,0) NOT NULL , 
				"PAATTY_NMR_FIFTH_LENGTH" NUMERIC(38,0) NOT NULL , 
				"PAATTY_NMR_FOURTH_LENGTH" NUMERIC(38,0) NOT NULL , 
				"PAATTY_NMR_THIRD_LENGTH" NUMERIC(38,0) NOT NULL , 
				"PAATTY_NMR_SECOND_LENGTH" NUMERIC(38,0) NOT NULL , 
	CONSTRAINT "PAATTY_PK" PRIMARY KEY ("PAATTY_ID"));
	--
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_ID" IS 'id del tipo de dato variable. Ejemplo: ACTION, CRX, etc';
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_DSC" IS 'descripcion de este tipo de dato y como aplica al negocio del parametro';
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_FLG_WS" IS 'indica si la lista de valores se debe ir a buscar a un web service corporativo o a la tabla local. Valor boolean Y or N'"";
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_NMR_VARIABLES" IS 'numero de campos que maneja esta variable. NO PUEDE SER MAYOR A 5 NI MENOR A 1';  
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_VLR_FIFTH_LABEL" IS 'label para el campo valor 5 de la variable';
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_VLR_FOURTH_LABEL" IS 'label para el campo valor 4 de la variable';
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_VLR_THIRD_LABEL" IS 'label para el campo valor 3 de la variable';
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_VLR_SECOND_LABEL" IS 'label para el campo valor 2 de la variable';
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_VLR_KEY_LABEL" IS 'label para el campo principal de la variable';
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_FLG_ACTIVE" IS 'Boolean Y/N indica que este tipo de datos esta activo en el sistema';
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_NMR_KEY_LENGTH" IS 'LARGO DEL VALOR POR DEFAULT';
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_NMR_FIFTH_LENGTH" IS 'LARGO DEL VALOR QUINTA COLUMNA';
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_NMR_FOURTH_LENGTH" IS 'LARGO DEL VALOR CUARTA COLUMNA';
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_NMR_THIRD_LENGTH" IS 'LARGO DEL VALOR TERCERA COLUMNA';
   -- COMMENT ON COLUMN "PARAMETRIC_ATT_TYPES"."PAATTY_NMR_SECOND_LENGTH" IS 'LARGO DEL VALOR SEGUNDA COLUMNA';
   -- COMMENT ON TABLE "PARAMETRIC_ATT_TYPES"  IS 'Tipos de variables parametricas. Ej: Action, CRX, Etc';

-------------------------------------------------------------------------------------------------------------------
--  SCHEMA FOR TABLE CONFIG_TYPES_VALUES
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE "CONFIG_TYPES_VALUES" (
  				"PAATTY_ID" VARCHAR(40) NOT NULL, 
				"TECONF_ID" VARCHAR(20) NOT NULL , 
				"COTYVA_FCH_MODIF" DATE, 
				"COTYVA_FCH_CREATED" DATE, 
  CONSTRAINT "COTYVA_PK" PRIMARY KEY ("PAATTY_ID", "TECONF_ID"),
  CONSTRAINT "COTYVA_FK_PAATTY_1" FOREIGN KEY ("PAATTY_ID")
  		REFERENCES "PARAMETRIC_ATT_TYPES" ("PAATTY_ID")); 
  --
  -- COMMENT ON COLUMN "CONFIG_TYPES_VALUES"."PAATTY_ID" IS 'Id del tipo de dato variable. Ejemplo: ACTION, CRX, etc';
  -- COMMENT ON COLUMN "CONFIG_TYPES_VALUES"."TECONF_ID" IS 'IDENTIFICADOR DEL TEMPLATE O CONFIGURACION';
  -- COMMENT ON TABLE "CONFIG_TYPES_VALUES"  IS 'VALORES TIPOS POR CONFIGURACION';

-------------------------------------------------------------------------------------------------------------------
-- SCHEMA FOR TABLE PARAMETRIC_ATT_VALUES
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE "PARAMETRIC_ATT_VALUES" (
  				"PAATVA_VLR_KEY" VARCHAR(40) NOT NULL , 
				"PAATVA_VLR_SECOND" VARCHAR(1000), 
				"PAATVA_VLR_FIFTH" VARCHAR(40), 
				"PAATVA_VLR_FOURTH" VARCHAR(40), 
				"PAATVA_VLR_THIRD" VARCHAR(40), 
				"PAATTY_ID" VARCHAR(40) NOT NULL , 
				"TECONF_ID" VARCHAR(20) NOT NULL , 
				"BE_DOUBLED" CHAR(1), 
  CONSTRAINT "PAATVA_PK" PRIMARY KEY ("PAATVA_VLR_KEY", "PAATTY_ID", "TECONF_ID"),
  CONSTRAINT "PAATVA_FK_COTYVA_1" FOREIGN KEY ("PAATTY_ID", "TECONF_ID")
  		REFERENCES "CONFIG_TYPES_VALUES" ("PAATTY_ID", "TECONF_ID"));
  --
  -- COMMENT ON COLUMN "PARAMETRIC_ATT_VALUES"."PAATVA_VLR_KEY" IS 'valor principal del parametro';
  -- COMMENT ON COLUMN "PARAMETRIC_ATT_VALUES"."PAATVA_VLR_SECOND" IS 'valor auxiliar del parametro, para la presentacion o logica';
  -- COMMENT ON COLUMN "PARAMETRIC_ATT_VALUES"."PAATVA_VLR_FIFTH" IS 'just in case we need more fields for this variable';
  -- COMMENT ON COLUMN "PARAMETRIC_ATT_VALUES"."PAATVA_VLR_FOURTH" IS 'valor adicional (campo de la variable) se usa solo en algunos casos';
  -- COMMENT ON COLUMN "PARAMETRIC_ATT_VALUES"."PAATVA_VLR_THIRD" IS 'valor adicional (campo de la variable) se usa solo en algunos casos';
  -- COMMENT ON COLUMN "PARAMETRIC_ATT_VALUES"."PAATTY_ID" IS 'id del tipo de dato variable. Ejemplo: ACTION, CRX, etc';
  -- COMMENT ON COLUMN "PARAMETRIC_ATT_VALUES"."TECONF_ID" IS 'IDENTIFICADOR DEL TEMPLATE O CONFIGURACION';
  -- COMMENT ON COLUMN "PARAMETRIC_ATT_VALUES"."BE_DOUBLED" IS 'Columna Identificador de si clase es duplicable o no';
  -- COMMENT ON TABLE  "PARAMETRIC_ATT_VALUES"  IS 'valores PARA cada una de las variables parametricas');

  CREATE SYNONYM "PAATVA" FOR "PARAMETRIC_ATT_VALUES";
 
-------------------------------------------------------------------------------------------------------------------
-- SCHEMA FOR TABLE ATT_VALUES_CONFIG
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE  "ATT_VALUES_CONFIG" (
				"TECONF_ID" VARCHAR(20) NOT NULL, 
				"TECONF_NMB" VARCHAR(30) NOT NULL, 
				"TECONF_FCH_MODIF" DATE, 
				"TECONF_FCH_CREATED" DATE NOT NULL, 
				"TECONF_FLG_ACTIVE" CHAR(1) NOT NULL, 
  CONSTRAINT "TECONF_PK" PRIMARY KEY ("TECONF_ID"));
  
--   COMMENT ON COLUMN "ATT_VALUES_CONFIG"."TECONF_ID" IS 'IDENTIFICADOR DEL TEMPLATE O CONFIGURACION';
--   COMMENT ON COLUMN "ATT_VALUES_CONFIG"."TECONF_NMB" IS 'NOMBRE DEL TEMPLATE O CONFIGURACION';
--   COMMENT ON COLUMN "ATT_VALUES_CONFIG"."TECONF_FCH_MODIF" IS 'FECHA ULTIMA MODIFICACION';
--   COMMENT ON COLUMN "ATT_VALUES_CONFIG"."TECONF_FCH_CREATED" IS 'FECHA DE CREACION';
--   COMMENT ON COLUMN "ATT_VALUES_CONFIG"."TECONF_FLG_ACTIVE" IS 'Boolean Y/N indica si la configuracion esta activa o no.';
--   COMMENT ON TABLE  "ATT_VALUES_CONFIG"  IS 'TEMPLATES CONFIGS';

-------------------------------------------------------------------------------------------------------------------
-- SCHEMA FOR TABLE VALID_COMBINATION_CCCF
-------------------------------------------------------------------------------------------------------------------
CREATE TABLE VALID_COMBINATION_CCCF(
  			 VCCCCF_PRM_CXR VARCHAR(2) NOT NULL, 
			 VCCCCF_PRM_CABIN VARCHAR(2) NOT NULL,
			 VCCCCF_PRM_CLASS VARCHAR(20) NOT NULL, 
			 VCCCCF_PRM_FAMILY VARCHAR(20) NOT NULL, 
			 TECONF_ID VARCHAR(20) NOT NULL,
			 VCCCCF_FCH_MODIF DATE NOT NULL,
			 VCCCCF_FCH_CREATED DATE NOT NULL,
			 VCCCCF_FLG_ACTIVE CHAR(1), 
 CONSTRAINT VCCCCF_PK PRIMARY KEY(TECONF_ID, VCCCCF_PRM_CXR, VCCCCF_PRM_CABIN, VCCCCF_PRM_CLASS, VCCCCF_PRM_FAMILY),
 CONSTRAINT VCCCCF_FK_TECONF_1 FOREIGN KEY(TECONF_ID)
 		REFERENCES ATT_VALUES_CONFIG(TECONF_ID));
 
-- COMMENT ON COLUMN VALID_COMBINATION_CCCF.VCCCCF_PRM_CXR IS 'Variable Parametrica del tipo CRX para el negocio al cual se desee consultar.';
-- COMMENT ON COLUMN VALID_COMBINATION_CCCF.VCCCCF_PRM_CABIN IS 'Variable Parametrica del tipo Cabin para el negocio al cual se desee consultar.';
-- COMMENT ON COLUMN VALID_COMBINATION_CCCF.VCCCCF_PRM_CLASS IS 'Variable Parametrica del tipo Class para el negocio al cual se desee consultar.';
-- COMMENT ON COLUMN VALID_COMBINATION_CCCF.VCCCCF_PRM_FAMILY IS 'Variable Parametrica del tipo Family para el negocio al cual se desee consultar.';
-- COMMENT ON COLUMN VALID_COMBINATION_CCCF.TECONF_ID IS 'IDENTIFICADOR DEL TEMPLATE O CONFIGURACION';
-- COMMENT ON COLUMN VALID_COMBINATION_CCCF.VCCCCF_FCH_MODIF IS 'fecha ultima modificacion';
-- COMMENT ON COLUMN VALID_COMBINATION_CCCF.VCCCCF_FCH_CREATED IS 'fecha creacion';
-- COMMENT ON COLUMN VALID_COMBINATION_CCCF.VCCCCF_FLG_ACTIVE IS 'Flag Y/N que indica si el registro esta activo o no';
-- COMMENT ON TABLE VALID_COMBINATION_CCCF IS 'MAPPING DE CRX/CABIN/CLASS/FAMILY SE USA PARA HACER VALIDACIONES Los campos crx, cabin, Class, y family deben coincidir de acuerdo A ESTA TABLA';

 CREATE SYNONYM "VCCCCF" FOR "VALID_COMBINATION_CCCF";

-------------------------------------------------------------------------------------------------------------------
-- SCHEMA FOR TABLE REQUEST_TYPES
-------------------------------------------------------------------------------------------------------------------
 CREATE TABLE REQUEST_TYPES (
  			  RQTYPE_ID VARCHAR(60) NOT NULL,
  			  RQTYPE_NMB VARCHAR(30) NOT NULL,
  			  RQTYPE_FLG_NEED_APROB_GERENT CHAR(1),
  			  RQTYPE_FLG_NEED_APROB_RM CHAR(1),
  			  RQTYPE_FLG_NEED_ODPOS CHAR(1),
  			  RQTYPE_TPO_VISIBILITY VARCHAR(20),
  			  RQTYPE_TPO_PROCESS VARCHAR(20),
  			  TECONF_ID VARCHAR(20),
  			  RQTYPE_ID_PARENT VARCHAR(20),
  			  RQTYPE_FLG_HIERARCHY CHAR(1),
  			  RQTYPE_FLG_HAS_ATTACHMENTS CHAR(1) DEFAULT 'N',
  			  RQTYPE_NMR_ORDER NUMERIC(38, 0), 
	CONSTRAINT RQTYPE_PK PRIMARY KEY(RQTYPE_ID),
	CONSTRAINT RQTYPE_FK_RQTYPE_1 FOREIGN KEY (RQTYPE_ID_PARENT) 
			REFERENCES REQUEST_TYPES(RQTYPE_ID),
	CONSTRAINT RQTYPE_FK_TECONF_1 FOREIGN KEY(TECONF_ID) REFERENCES ATT_VALUES_CONFIG(TECONF_ID));

-- COMMENT ON COLUMN REQUEST_TYPES.RQTYPE_ID IS 'ID unico de tipo de requerimiento.';
-- COMMENT ON COLUMN REQUEST_TYPES.RQTYPE_NMB IS 'Nombre del requerimiento.';
-- COMMENT ON COLUMN REQUEST_TYPES.RQTYPE_FLG_NEED_APROB_GERENT IS 'Booleano Y/N. Indica si el requerimiento necesitará aprobacion desde gerente o subgerente segun aplique.';
-- COMMENT ON COLUMN REQUEST_TYPES.RQTYPE_FLG_NEED_APROB_RM IS 'Booleano Y/N. Indica si el requerimiento necesita aprobacion desde el area RM.';
-- COMMENT ON COLUMN REQUEST_TYPES.RQTYPE_FLG_NEED_ODPOS IS 'Booleano Y/N.Indica si el requerimiento requiere el Origen Destino POS.';
-- COMMENT ON COLUMN REQUEST_TYPES.RQTYPE_TPO_VISIBILITY IS 'VISIBILIDAD: PUBLIC, PRIVATE or ALL.';
-- COMMENT ON COLUMN REQUEST_TYPES.RQTYPE_TPO_PROCESS IS 'Tipo de proceso asociado al requerimeinto. solo puede ser ''PROACTIVE'' OR ''REACTIVE''';
-- COMMENT ON COLUMN REQUEST_TYPES.TECONF_ID IS 'IDENTIFICADOR DEL TEMPLATE O CONFIGURACION';
-- COMMENT ON COLUMN REQUEST_TYPES.RQTYPE_ID_PARENT IS 'Este dato se usa para identificar al padre de este apellido o subtipo. si este campo es null quiere decir que el type es root, es decir no es un apellido. si este campo tiene referencia a un padre indica que es apellido de ese tipo-.
--
-- se usa en conjunto con RQTYPE_FLG_HIERARCHY que  indica que se debe considerar toda la jerarquía del tipo (incluir los subtipos para contabilizar, etc).';
-- COMMENT ON COLUMN REQUEST_TYPES.RQTYPE_FLG_HIERARCHY IS ' indica que se debe considerar toda la jerarquía del tipo (incluir los subtipos para contabilizar, etc).';
-- COMMENT ON COLUMN REQUEST_TYPES.RQTYPE_FLG_HAS_ATTACHMENTS IS 'indica si el tipo de requerimiento maneja archivos adjuntos';
-- COMMENT ON COLUMN REQUEST_TYPES.RQTYPE_NMR_ORDER IS 'orden de peso del requerimiento se usa para el orden en las listas';COMMENT ON TABLE REQUEST_TYPES IS 'Tabla donde se almacenan todos los tipos de requerimientos y su descripcion
--
-- Posibles valores son todos los tipos de requerimientos existentes
-- 
-- PROMO / EETT - INTER
-- PROMO / EETT - BRASIL
-- PROMO / EETT - SSC
-- Surcharge
-- Cambios de Season
-- Cambios de DOW
-- Cambios de Routing
-- Crear / Modificar Add-On
-- Cambios de DOW/FL
-- Alzas/Bajas Masivas
-- Sales Smart Business
-- Sales Smart Online
-- Sales Corporativo
-- Sales Last Minute
-- Sales Operadora
-- Otros
-- Lista de distribución
-- Cambio FL privadas
-- cambio BO
-- Sale-travel restrict
-- MN o AP
-- FBR
-- Netas Privadas
-- Politicas Match

	CREATE SYNONYM "RQTYPE" FOR "REQUEST_TYPES";

------------------------------------------------------------------------------------------------------------------
-- SCHEMA FOR TABLE VALID_COMBINATION_OD
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE  "VALID_COMBINATION_OD" (
  				"VCOMOD_PRM_CXR" VARCHAR(512) NOT NULL, 
				"VCOMOD_VLR_ORIGIN" VARCHAR(20) NOT NULL, 
				"VCOMOD_VLR_DEST" VARCHAR(20) NOT NULL, 
				"VCOMOD_PRM_CABIN" VARCHAR(512) NOT NULL, 
				"VCOMOD_VLR_MARKET" VARCHAR(2) NOT NULL, 
				"VCOMOD_NMR_ROUTING" NUMERIC(4,0) NOT NULL, 
				"VCOMOD_NMR_TARIF_PRIVATE2" NUMERIC(3,0), 
				"VCOMOD_NMR_TARIF_PRIVATE1" NUMERIC(3,0) NOT NULL, 
				"VCOMOD_NMR_TARIF_VIA_PA" NUMERIC(3,0) NOT NULL, 
				"VCOMOD_NMR_TARIF_VIA_AT" NUMERIC(3,0) NOT NULL, 
				"VCOMOD_VLR_SURCHARGE" VARCHAR(10), 
				"VCOMOD_NMR_MAX_AMOUNT2" NUMERIC(8,0), 
				"VCOMOD_NMR_MAX_AMOUNT1" NUMERIC(8,0) NOT NULL, 
				"VCOMOD_NMR_MIN_AMOUNT2" NUMERIC(8,0), 
				"VCOMOD_NMR_MIN_AMOUNT1" NUMERIC(8,0) NOT NULL, 
				"VCOMOD_PRM_CURRENCY2" VARCHAR(3), 
				"VCOMOD_PRM_CURRENCY1" VARCHAR(3) NOT NULL, 
				"VCOMOD_FLG_KMS" CHAR(1), 
				"VCOMOD_FCH_MODIF" DATE NOT NULL, 
				"VCOMOD_FCH_CREATED" DATE NOT NULL, 
				"VCOMOD_VLR_DEST_REGION" VARCHAR(20) NOT NULL, 
				"VCOMOD_VLR_DEST_COUNTRY" VARCHAR(20) NOT NULL, 
				"VCOMOD_VLR_ORIGIN_REGION" VARCHAR(20) NOT NULL, 
				"VCOMOD_VLR_ORIGIN_COUNTRY" VARCHAR(20) NOT NULL, 
				"VCOMOD_VLR_POS" VARCHAR(1), 
				"VCOMOD_FLG_ACTIVE" CHAR(1), 
	 CONSTRAINT "VCOMOD_PK" PRIMARY KEY ("VCOMOD_VLR_ORIGIN", "VCOMOD_VLR_DEST", "VCOMOD_PRM_CABIN"));
  
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_PRM_CXR" IS 'Variable Parametrica del tipo CXR para el negocio al cual se desee consultar. Se pueden ingresar varias separadas por comma';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_VLR_ORIGIN" IS 'Ciudad/Aeropuerto. Fuente de datos WS';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_VLR_DEST" IS 'Ciudad/Aeropuerto. Fuente de datos WS';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_PRM_CABIN" IS 'Variable Parametrica del tipo Cabin para el negocio al cual se desee consultar. Se pueden ingresar varias separadas por comma';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_VLR_MARKET" IS 'Negocio al que aplica';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_NMR_ROUTING" IS 'Numero de routing';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_NMR_TARIF_PRIVATE2" IS 'Variable Parametrica';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_NMR_TARIF_PRIVATE1" IS 'Variable Parametrica';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_NMR_TARIF_VIA_PA" IS 'valor de la tarifa via PA';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_NMR_TARIF_VIA_AT" IS 'valor de la tarifa via AT';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_VLR_SURCHARGE" IS 'Notese que esta es VLR no es PRM. por ende no tiene nada que ver con las PRM Surcharge.
-- Valores posibles:
-- Si,
-- No,
-- Si + YQ,
-- No + YQ.';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_NMR_MAX_AMOUNT2" IS 'monto maximo 2';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_NMR_MAX_AMOUNT1" IS 'monto maximo 1';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_NMR_MIN_AMOUNT2" IS 'monto minimo 2';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_NMR_MIN_AMOUNT1" IS 'monto minimo 1';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_PRM_CURRENCY2" IS 'currencies';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_PRM_CURRENCY1" IS 'currencies';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_FLG_KMS" IS 'Boolean Y/N indica si aplica o no aplica KMS';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_FCH_MODIF" IS 'FECHA ULTIMA MODIFICACION';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_FCH_CREATED" IS 'FECHA CREACION';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_VLR_DEST_REGION" IS 'Region destino';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_VLR_DEST_COUNTRY" IS 'Pais destino';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_VLR_ORIGIN_REGION" IS 'Region origin';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_VLR_ORIGIN_COUNTRY" IS 'Pais Origin';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_VLR_POS" IS 'pais origen (POS) de  1 char';
-- COMMENT ON COLUMN "VALID_COMBINATION_OD"."VCOMOD_FLG_ACTIVE" IS 'Flag Y/N';
-- COMMENT ON TABLE  "VALID_COMBINATION_OD"  IS 'COMBINACIONES VALIDAS DE PARAMETRICAS OD INTER Y DOMSSC';

	CREATE SYNONYM "VCOMOD" FOR "VALID_COMBINATION_OD";
	
COMMIT;
	
