 -------------------------------------------------------------------------------------------------------------------
-- TABLE VALID_COMBINATION_OD - CONFIG : CABINA - CONVINATION : 
-- CLASE = V
-- ORIGEN = SCL
-- DESTINO = MIA
-------------------------------------------------------------------------------------------------------------------
 SELECT
    VCOMOD_VLR_ORIGIN, 
    VCOMOD_VLR_DEST,
    VCOMOD_PRM_CXR, 
    VCOMOD_PRM_CABIN,
    VCOMOD_VLR_MARKET, 
    VCOMOD_NMR_ROUTING,
    VCOMOD_NMR_TARIF_PRIVATE2,
    VCOMOD_NMR_TARIF_PRIVATE1,
    VCOMOD_NMR_TARIF_VIA_PA, 
    VCOMOD_NMR_TARIF_VIA_AT,
    VCOMOD_VLR_SURCHARGE,
    VCOMOD_NMR_MAX_AMOUNT2,
    VCOMOD_NMR_MAX_AMOUNT1, 
    VCOMOD_NMR_MIN_AMOUNT2,
    VCOMOD_NMR_MIN_AMOUNT1,
    VCOMOD_PRM_CURRENCY2,
    VCOMOD_PRM_CURRENCY1, 
    VCOMOD_FLG_KMS,
    VCOMOD_FCH_MODIF, 
    VCOMOD_FCH_CREATED,
    VCOMOD_VLR_DEST_REGION,
    VCOMOD_VLR_DEST_COUNTRY, 
    VCOMOD_VLR_ORIGIN_REGION,
    VCOMOD_VLR_ORIGIN_COUNTRY,
    VCOMOD_VLR_POS,
    VCOMOD_FLG_ACTIVE
    FROM VCOMOD
    WHERE VCOMOD.VCOMOD_VLR_ORIGIN = 'SCL' AND -- Origen
         (VCOMOD.VCOMOD_VLR_DEST = 'MIA' OR 'MIA' IS NULL) AND -- Destino
         (VCOMOD.VCOMOD_PRM_CABIN = NULL or NULL is NULL) AND -- Cabina
         REGEXP_LIKE (VCOMOD.VCOMOD_PRM_CXR, '(LA)') AND -- Carriers
         REGEXP_COUNT (VCOMOD.VCOMOD_PRM_CXR, '(LA)') = 1 AND -- Cantidad de Carriers
         --CUANDO SON MAS CARRIERS
         --REGEXP_LIKE (VCOMOD.VCOMOD_PRM_CXR, '(LA)|(XL)') AND -- Carriers
         --REGEXP_COUNT (VCOMOD.VCOMOD_PRM_CXR, '(LA)|(XL)') = 1 AND -- Cantidad de Carriers
         VCOMOD_FLG_ACTIVE = 'Y';
         

 -------------------------------------------------------------------------------------------------------------------
-- TABLE VALID_COMBINATION_OD - CONFIG : CABINA - CONVINATION: 
-- CLASE = V
-- ORIGEN = GYE
-- DESTINO = MIA
-------------------------------------------------------------------------------------------------------------------
 SELECT
    VCOMOD_VLR_ORIGIN, 
    VCOMOD_VLR_DEST,
    VCOMOD_PRM_CXR, 
    VCOMOD_PRM_CABIN,
    VCOMOD_VLR_MARKET, 
    VCOMOD_NMR_ROUTING,
    VCOMOD_NMR_TARIF_PRIVATE2,
    VCOMOD_NMR_TARIF_PRIVATE1,
    VCOMOD_NMR_TARIF_VIA_PA, 
    VCOMOD_NMR_TARIF_VIA_AT,
    VCOMOD_VLR_SURCHARGE,
    VCOMOD_NMR_MAX_AMOUNT2,
    VCOMOD_NMR_MAX_AMOUNT1, 
    VCOMOD_NMR_MIN_AMOUNT2,
    VCOMOD_NMR_MIN_AMOUNT1,
    VCOMOD_PRM_CURRENCY2,
    VCOMOD_PRM_CURRENCY1, 
    VCOMOD_FLG_KMS,
    VCOMOD_FCH_MODIF, 
    VCOMOD_FCH_CREATED,
    VCOMOD_VLR_DEST_REGION,
    VCOMOD_VLR_DEST_COUNTRY, 
    VCOMOD_VLR_ORIGIN_REGION,
    VCOMOD_VLR_ORIGIN_COUNTRY,
    VCOMOD_VLR_POS,
    VCOMOD_FLG_ACTIVE
    FROM VCOMOD
    WHERE VCOMOD.VCOMOD_VLR_ORIGIN = 'SCL' AND -- Origen
         (VCOMOD.VCOMOD_VLR_DEST = 'MIA' OR 'MIA' IS NULL) AND -- Destino
         (VCOMOD.VCOMOD_PRM_CABIN = NULL or NULL is NULL) AND -- Cabina
         REGEXP_LIKE (VCOMOD.VCOMOD_PRM_CXR, '(LA)') AND -- Carriers
         REGEXP_COUNT (VCOMOD.VCOMOD_PRM_CXR, '(LA)') = 1 AND -- Cantidad de Carriers
         --CUANDO SON MAS CARRIERS
         --REGEXP_LIKE (VCOMOD.VCOMOD_PRM_CXR, '(LA)|(XL)') AND -- Carriers
         --REGEXP_COUNT (VCOMOD.VCOMOD_PRM_CXR, '(LA)|(XL)') = 1 AND -- Cantidad de Carriers
         VCOMOD_FLG_ACTIVE = 'Y';
         
         
         