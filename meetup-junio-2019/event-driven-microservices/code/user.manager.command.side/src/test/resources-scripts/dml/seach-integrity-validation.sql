-- MUESTRA LA CONFIGURACION PARA EL FORMULARIO PERU
-------------------------------------------------------------------------------------------------------------------
-- TABLE PARAMETRIC_ATT_VALUES - CONFIG : SEASON/DOW/TOD/FL - DOM PE
-------------------------------------------------------------------------------------------------------------------
SELECT PAATTY_ID, PAATVA_VLR_KEY, TECONF_ID,
		PAATVA_VLR_SECOND,
		PAATVA_VLR_FIFTH,
		PAATVA_VLR_FOURTH, PAATVA_VLR_THIRD
FROM PAATVA
WHERE
	 PAATTY_ID = 'SEASON/DOW/TOD/FL'	AND TECONF_ID = 'DOM PE';

-------------------------------------------------------------------------------------------------------------------
-- TABLE PARAMETRIC_ATT_VALUES - CONFIG : AP - DOM PE
-------------------------------------------------------------------------------------------------------------------
SELECT PAATTY_ID, PAATVA_VLR_KEY, TECONF_ID,
		PAATVA_VLR_SECOND,
		PAATVA_VLR_FIFTH,
		PAATVA_VLR_FOURTH, PAATVA_VLR_THIRD
FROM PAATVA
WHERE
	 PAATTY_ID = 'AP'	AND TECONF_ID = 'DOM PE';
     
-------------------------------------------------------------------------------------------------------------------
-- TABLE PARAMETRIC_ATT_VALUES - CONFIG : MN - DOM PE
-------------------------------------------------------------------------------------------------------------------
SELECT PAATTY_ID, PAATVA_VLR_KEY, TECONF_ID,
		PAATVA_VLR_SECOND,
		PAATVA_VLR_FIFTH,
		PAATVA_VLR_FOURTH, PAATVA_VLR_THIRD
FROM PAATVA
WHERE
	 PAATTY_ID = 'MN'	AND TECONF_ID = 'DOM PE';
     
     
-------------------------------------------------------------------------------------------------------------------
-- TABLE PARAMETRIC_ATT_VALUES - CONFIG : ACTION - DOM PE
-------------------------------------------------------------------------------------------------------------------
SELECT PAATTY_ID, PAATVA_VLR_KEY, TECONF_ID,
		PAATVA_VLR_SECOND,
		PAATVA_VLR_FIFTH,
		PAATVA_VLR_FOURTH, PAATVA_VLR_THIRD
FROM PAATVA
WHERE
	 PAATTY_ID = 'ACTION'	AND TECONF_ID = 'DOM PE';     
     
-------------------------------------------------------------------------------------------------------------------
-- TABLE PARAMETRIC_ATT_VALUES - CONFIG : Routing FL - DOM PE
-------------------------------------------------------------------------------------------------------------------
SELECT PAATTY_ID, PAATVA_VLR_KEY, TECONF_ID,
		PAATVA_VLR_SECOND,
		PAATVA_VLR_FIFTH,
		PAATVA_VLR_FOURTH, PAATVA_VLR_THIRD
FROM PAATVA
WHERE
	 PAATTY_ID = 'Routing FL'	AND TECONF_ID = 'DOM PE';     
          

-------------------------------------------------------------------------------------------------------------------
-- TABLE PARAMETRIC_ATT_VALUES - CONFIG : Surcharge - DOM PE
-------------------------------------------------------------------------------------------------------------------
SELECT PAATTY_ID, PAATVA_VLR_KEY, TECONF_ID,
		PAATVA_VLR_SECOND,
		PAATVA_VLR_FIFTH,
		PAATVA_VLR_FOURTH, PAATVA_VLR_THIRD
FROM PAATVA
WHERE
	 PAATTY_ID = 'Surcharge' AND TECONF_ID = 'DOM PE';     

-------------------------------------------------------------------------------------------------------------------
-- RELATED TABLES
-------------------------------------------------------------------------------------------------------------------

SELECT * FROM PARAMETRIC_ATT_VALUES;
SELECT * FROM CONFIG_TYPES_VALUES;
SELECT * FROM PARAMETRIC_ATT_TYPES;
     