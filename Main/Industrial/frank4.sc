MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// ***********************************Final Industrial****************************************
// ***********************************go to commercial****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_frank4

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_frank4_failed
ENDIF
						 
GOSUB mission_cleanup_frank4

MISSION_END					


// Variables for mission


//VAR_INT maria // mission specific ped

VAR_INT blip1_fm4 blip2_fm4 blip3_fm4 boat_blip

VAR_INT flag_player_got_frank4_message frank4_car1 frank4_car2

VAR_INT boat_mar bomb_car  flag_car_blip_displayed_fm4

VAR_INT car_dead_once girls_attack_player

VAR_FLOAT boat_mar_X boat_mar_Y boat_mar_Z

// ***************************************Mission Start*************************************

mission_start_frank4:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_frankie_mission = 1
SCRIPT_NAME frank4
WAIT 0

girls_attack_player = 0
car_dead_once = 0


{

LOAD_SPECIAL_CHARACTER 1 frankie
//LOAD_SPECIAL_CHARACTER 2 goon
LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 FRANKH

REQUEST_MODEL PED_GANG_MAFIA_B
REQUEST_MODEL franksclb02
REQUEST_MODEL salvsdetail
REQUEST_MODEL swank_inside

/*
WHILE GET_FADING_STATUS
	WAIT 0

ENDWHILE
*/

LOAD_ALL_MODELS_NOW
				  
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED PED_GANG_MAFIA_B
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED franksclb02
OR NOT HAS_MODEL_LOADED	salvsdetail
OR NOT HAS_MODEL_LOADED swank_inside
	WAIT 0

ENDWHILE


LOAD_CUTSCENE S5_LRQ
SET_CUTSCENE_OFFSET 1457.776 -185.348 54.925

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_frankie
SET_CUTSCENE_ANIM cs_frankie frankie

CREATE_CUTSCENE_HEAD cs_frankie CUT_OBJ2 cs_frankiehead
SET_CUTSCENE_HEAD_ANIM cs_frankiehead frank

CREATE_CUTSCENE_OBJECT PED_GANG_MAFIA_B cs_mafia
SET_CUTSCENE_ANIM cs_mafia gang02

//CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_mafia
//SET_CUTSCENE_ANIM cs_mafia gang02

SET_PLAYER_COORDINATES player 1455.2 -186.8 55.0

SET_PLAYER_HEADING player 130.0

DO_FADE 1500 FADE_IN

//SWITCH_WORLD_PROCESSING OFF
SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time


WHILE cs_time < 2397
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_A ) 10000 1 // Mission brief

WHILE cs_time < 5260
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_B ) 10000 1 // Mission brief

WHILE cs_time < 9273
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_C ) 10000 1 // Mission brief

WHILE cs_time < 12861
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_D ) 10000 1 // Mission brief

WHILE cs_time < 15447
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_E ) 10000 1 // Mission brief

WHILE cs_time < 18080
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_F ) 10000 1 // Mission brief

WHILE cs_time < 22832
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_H ) 10000 1 // Mission brief

WHILE cs_time < 24908
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS 

WHILE cs_time < 26333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1000 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

//SWITCH_WORLD_PROCESSING ON
SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

WAIT 500

DO_FADE 1000 FADE_IN 

UNLOAD_SPECIAL_CHARACTER 1
//UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_B
MARK_MODEL_AS_NO_LONGER_NEEDED franksclb02
MARK_MODEL_AS_NO_LONGER_NEEDED salvsdetail
MARK_MODEL_AS_NO_LONGER_NEEDED swank_inside
//REQUEST_MODEL BOAT_SPEEDER
//REQUEST_MODEL CAR_CHEETAH
//LOAD_SPECIAL_MODEL cut_obj3 MARIAH
//LOAD_SPECIAL_MODEL cut_obj4 ASUKAH

	/*
	WHILE NOT HAS_MODEL_LOADED cut_obj3
	OR NOT HAS_MODEL_LOADED cut_obj4
		WAIT 0
	ENDWHILE
	*/

REQUEST_MODEL BOAT_REEFER
REQUEST_MODEL CAR_CHEETAH

	WHILE NOT HAS_MODEL_LOADED BOAT_REEFER
	OR NOT HAS_MODEL_LOADED	CAR_CHEETAH
		WAIT 0

	ENDWHILE

//GOTO skip_frank_cut1 //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//CREATE SUBURBAN BARRIERS
IF barriers_been_added = 0

	CREATE_OBJECT_NO_OFFSET subwaygate -672.0 -760.0 8.3 subway_gate_suburban1
	DONT_REMOVE_OBJECT subway_gate_suburban1
	SET_OBJECT_HEADING subway_gate_suburban1 270.0   

	CREATE_OBJECT_NO_OFFSET subwaygate -672.0 -768.9 8.3 subway_gate_suburban2
	DONT_REMOVE_OBJECT subway_gate_suburban2
	SET_OBJECT_HEADING subway_gate_suburban2 270.0

	CREATE_OBJECT_NO_OFFSET tunnelentrance 533.3 97.0 -21.3 tunnel_gate_suburban
	DONT_REMOVE_OBJECT tunnel_gate_suburban
	SET_OBJECT_HEADING tunnel_gate_suburban 45.0
	
	barriers_been_added = 1
ENDIF

// START OF MISSION

CREATE_CAR CAR_CHEETAH 951.0 -421.0 14.6 bomb_car
ARM_CAR_WITH_BOMB bomb_car CARBOMB_ONIGNITIONACTIVE 
ADD_BLIP_FOR_CAR bomb_car blip1_fm4 

WHILE NOT IS_PLAYER_IN_ZONE Player REDLIGH
	 WAIT 0

	IF IS_CAR_DEAD bomb_car
	AND car_dead_once = 0
		REMOVE_BLIP blip1_fm4
		car_dead_once = 1 	
	ENDIF
	
ENDWHILE

ADD_PAGER_MESSAGE ( FM4_1 ) 140 10 2

ADD_BLIP_FOR_COORD 835.7 -1091.7 -100.0 blip2_fm4
/*
CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 835.6 -1110.7 2.0 maria
ADD_BLIP_FOR_CHAR maria blip2_fm4
CHAR_SET_IDLE maria
CLEAR_CHAR_THREAT_SEARCH maria
SET_CHAR_HEADING maria 345.0

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL3 834.3 -1111.7 2.0 asuka
CHAR_SET_IDLE asuka
CLEAR_CHAR_THREAT_SEARCH asuka
SET_CHAR_HEADING asuka 5.0
*/
WHILE NOT LOCATE_STOPPED_PLAYER_IN_CAR_3D Player 827.3 -1084.3 6.8 5.0 5.0 4.0 TRUE
	 WAIT 0

		IF IS_CAR_DEAD bomb_car
		AND car_dead_once = 0
			REMOVE_BLIP blip1_fm4
			car_dead_once = 1 	
		ENDIF

		IF LOCATE_PLAYER_ON_FOOT_3D Player  827.3 -1084.3 6.8 5.0 5.0 4.0 FALSE
			GOTO on_foot_frank4
		ENDIF

		/*
		IF IS_PLAYER_IN_CAR Player bomb_car
			GOTO mission_frank4_failed
		ENDIF		
		*/
ENDWHILE

on_foot_frank4:

SET_PLAYER_CONTROL Player Off

//skip_frank_cut1: //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//SET_PLAYER_COORDINATES player 845.5 -1098.0 -100.0 //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

FORCE_WEATHER_NOW WEATHER_SUNNY

REMOVE_BLIP blip1_fm4
REMOVE_BLIP blip2_fm4


//MEET MARIA ON THE INDUSTRIAL PIER CUT SCENE****************************************************************************

	GET_GAME_TIMER breakout_timer_start
	breakout_diff = 0

	WHILE NOT CAN_PLAYER_START_MISSION Player
	AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway
		WAIT 0

		GET_GAME_TIMER breakout_timer							
		breakout_diff = breakout_timer - breakout_timer_start
	ENDWHILE

	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player

//LOAD_SPECIAL_MODEL cut_obj1 PLAYERH

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

LOAD_SPECIAL_CHARACTER 2 maria
LOAD_SPECIAL_CHARACTER 3 asuka
LOAD_SPECIAL_MODEL cut_obj2 MARIAH
LOAD_SPECIAL_MODEL cut_obj3 ASUKAH

//PRINT_BIG ( FM4 ) 15000 2 //"Frankie Mission 4"	 

WHILE GET_FADING_STATUS
	WAIT 0

ENDWHILE

CREATE_CAR BOAT_REEFER 835.0 -1117.0 0.4 boat_mar
SET_CAR_HEADING boat_mar 143.0
ANCHOR_BOAT boat_mar TRUE
BOAT_STOP boat_mar


LOAD_ALL_MODELS_NOW
			  
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3 
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
	WAIT 0

ENDWHILE


LOAD_CUTSCENE S5_LRQB
SET_CUTSCENE_OFFSET 831.0839 -1114.2113 0.1822
//SET_CUTSCENE_OFFSET 830.0839 -1114.2113 0.1822

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_maria
SET_CUTSCENE_ANIM cs_maria maria

CREATE_CUTSCENE_OBJECT PED_SPECIAL3 cs_asuka
SET_CUTSCENE_ANIM cs_asuka asuka

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_maria CUT_OBJ2 cs_mariahead
SET_CUTSCENE_HEAD_ANIM cs_mariahead maria

CREATE_CUTSCENE_HEAD cs_asuka CUT_OBJ3 cs_asukahead
SET_CUTSCENE_HEAD_ANIM cs_asukahead asuka

//SET_PLAYER_COORDINATES player 835.4 -1108.7 1.0

//SET_PLAYER_HEADING player 230.0

IF NOT IS_CAR_DEAD boat_mar
	IF IS_PLAYER_IN_ANY_CAR player
		WARP_PLAYER_FROM_CAR_TO_COORD Player 835.4 -1108.7 1.0
	ENDIF
ENDIF

WARP_PLAYER_INTO_CAR Player boat_mar

DO_FADE 1500 FADE_IN

//SWITCH_WORLD_PROCESSING OFF
SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 697
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_2 ) 10000 1 // Mission brief

WHILE cs_time < 3275
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_3 ) 10000 1 // Mission brief

WHILE cs_time < 6479
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_4 ) 10000 1 // Mission brief

WHILE cs_time < 9000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_4B ) 10000 1 // Mission brief

WHILE cs_time < 11356
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_5 ) 10000 1 // Mission brief

WHILE cs_time < 13307
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_6 ) 10000 1 // Mission brief

WHILE cs_time < 16285
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_6B ) 10000 1 // Mission brief

WHILE cs_time < 19438
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_7 ) 10000 1 // Mission brief

WHILE cs_time < 23340
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_8 ) 10000 1 // Mission brief

WHILE cs_time < 24733
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( FM4_9 ) 10000 1 // Mission brief

WHILE cs_time < 30156
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 31666
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

/*
IF NOT IS_CAR_DEAD boat_mar
	SET_CAR_COORDINATES boat_mar 834.9 -1116.5 0.5 
	SET_CAR_HEADING boat_mar 143.0
ENDIF
*/
DO_FADE 1000 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

//SWITCH_WORLD_PROCESSING ON
SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_PLAYER_CONTROL Player ON
SET_CAMERA_BEHIND_PLAYER


CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 837.0 -1116.5 1.8 maria
SET_CHAR_ONLY_DAMAGED_BY_PLAYER maria TRUE
SET_CHAR_HEADING maria 17.0
SET_CHAR_STAYS_IN_CURRENT_LEVEL maria FALSE
SET_CHAR_IGNORE_LEVEL_TRANSITIONS maria TRUE
//boat_mar_Y = boat_mar_Y	- 1.0

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL3 836.6 -1114.6 1.8 asuka
SET_CHAR_ONLY_DAMAGED_BY_PLAYER asuka TRUE
SET_CHAR_HEADING asuka 178.0
SET_CHAR_STAYS_IN_CURRENT_LEVEL asuka FALSE
SET_CHAR_IGNORE_LEVEL_TRANSITIONS asuka TRUE

SET_CHARS_CHATTING maria asuka 999999

TURN_CHAR_TO_FACE_CHAR asuka maria

IF NOT IS_CAR_DEAD boat_mar
	ADD_BLIP_FOR_COORD 565.3 -678.4 -100.0 blip3_fm4
	ADD_BLIP_FOR_CAR boat_mar boat_blip
ENDIF

WAIT 500

DO_FADE 1000 FADE_IN 

//UNLOAD_SPECIAL_CHARACTER 2
//UNLOAD_SPECIAL_CHARACTER 3
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3

//GOTO skip_frank_cut2 //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	IF NOT IS_CAR_DEAD boat_mar
		ANCHOR_BOAT boat_mar FALSE
	ENDIF

	flag_car_blip_displayed_fm4 = TRUE

	IF IS_CHAR_DEAD	asuka
	OR IS_CHAR_DEAD maria
		GOTO mission_frank4_failed	
	ENDIF

WHILE NOT IS_PLAYER_IN_AREA_3D Player 565.3 -678.4 -2.0 575.3 -688.4 4.0 TRUE
OR NOT IS_CHAR_IN_AREA_3D maria 565.3 -678.4 -2.0 575.3 -688.4 4.0 FALSE
OR NOT IS_CHAR_IN_AREA_3D asuka 565.3 -678.4 -2.0 575.3 -688.4 4.0 FALSE
//OR NOT IS_PLAYER_IN_CAR player boat_mar
	 WAIT 0

		IF IS_CAR_DEAD boat_mar
			GOTO mission_frank4_failed
		ENDIF
	
		IF IS_CHAR_DEAD	asuka
		OR IS_CHAR_DEAD maria
			GOTO mission_frank4_failed	
		ENDIF
		
		IF IS_PLAYER_IN_CAR player boat_mar
			IF flag_car_blip_displayed_fm4 = TRUE
				REMOVE_BLIP blip3_fm4
				ADD_BLIP_FOR_COORD 565.3 -678.4 -100.0 blip3_fm4
				REMOVE_BLIP boat_blip
				flag_car_blip_displayed_fm4 = FALSE
			ENDIF
		ENDIF

		IF NOT IS_PLAYER_IN_CAR player boat_mar
			IF flag_car_blip_displayed_fm4 = FALSE
				REMOVE_BLIP	boat_blip
				ADD_BLIP_FOR_CAR boat_mar boat_blip
				REMOVE_BLIP blip3_fm4
				PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the vehicle!"
				flag_car_blip_displayed_fm4 = TRUE
			ENDIF
		ENDIF

		IF girls_attack_player = 0
			IF NOT IS_CHAR_HEALTH_GREATER asuka 96
			OR NOT IS_CHAR_HEALTH_GREATER maria 96
				IF NOT IS_CHAR_DEAD	asuka
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT asuka Player
					GIVE_WEAPON_TO_CHAR asuka WEAPONTYPE_UZI 200
				ENDIF
				IF NOT IS_CHAR_DEAD	maria
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT maria Player
					GIVE_WEAPON_TO_CHAR maria WEAPONTYPE_UZI 200
				ENDIF
				girls_attack_player = 1
			ENDIF	
		ENDIF
		 
ENDWHILE

IF NOT IS_CAR_DEAD boat_mar
	ANCHOR_BOAT boat_mar TRUE
	BOAT_STOP boat_mar
ENDIF

CLEAR_PRINTS
REMOVE_BLIP blip3_fm4

//skip_frank_cut2: //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//SET_PLAYER_COORDINATES player 559.4 -791.9 -100.0 //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//EVERYONE OFF THE BOAT IN COMMERCIAL CUTSCENE**************************************************************************

	GET_GAME_TIMER breakout_timer_start
	breakout_diff = 0

	WHILE NOT CAN_PLAYER_START_MISSION Player
	AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway
		WAIT 0

		IF IS_CAR_DEAD boat_mar
			GOTO mission_frank4_failed
		ENDIF
	
		IF IS_CHAR_DEAD	asuka
		OR IS_CHAR_DEAD maria
			GOTO mission_frank4_failed	
		ENDIF

		GET_GAME_TIMER breakout_timer							
		breakout_diff = breakout_timer - breakout_timer_start
	ENDWHILE

	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player


SET_FADING_COLOUR 0 0 0

DO_FADE 1000 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0

ENDWHILE

LOAD_COLLISION_WITH_SCREEN Level_commercial

IF NOT IS_CAR_DEAD boat_mar
	IF IS_PLAYER_IN_ANY_CAR player
		WARP_PLAYER_FROM_CAR_TO_COORD Player 515.1 -650.9 16.0//612.3 -674.5 1.8
	ENDIF
ENDIF

SET_PLAYER_COORDINATES player 515.1 -650.9 16.0 //612.3 -674.5 1.8
SET_PLAYER_HEADING player 90.0

SWITCH_STREAMING OFF

LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 MARIAH
LOAD_SPECIAL_MODEL cut_obj3 ASUKAH
REQUEST_MODEL CAR_YAKUZA
REQUEST_MODEL CAR_BLISTA


//PRINT_BIG ( FM4 ) 15000 2 //"Frankie Mission 4"	 

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED CAR_YAKUZA
OR NOT HAS_MODEL_LOADED	CAR_BLISTA
	WAIT 0

ENDWHILE

DELETE_CHAR maria
DELETE_CHAR asuka

LOAD_CUTSCENE S5_LRQC
SET_CUTSCENE_OFFSET 523.102 -636.96 15.616 //563.0 -683.0 1.8
	
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_maria
SET_CUTSCENE_ANIM cs_maria maria

CREATE_CUTSCENE_OBJECT PED_SPECIAL3 cs_asuka
SET_CUTSCENE_ANIM cs_asuka asuka

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_maria CUT_OBJ2 cs_mariahead
SET_CUTSCENE_HEAD_ANIM cs_mariahead maria

CREATE_CUTSCENE_HEAD cs_asuka CUT_OBJ3 cs_asukahead
SET_CUTSCENE_HEAD_ANIM cs_asukahead asuka

DO_FADE 1000 FADE_IN

SET_PLAYER_COORDINATES player 515.1 -650.9 16.0
SET_PLAYER_HEADING player 90.0

CREATE_CAR CAR_YAKUZA 500.0 -659.4 -100.0 frank4_car1

CREATE_CAR CAR_BLISTA 486.5 -643.6 -100.0 frank4_car2

MARK_MODEL_AS_NO_LONGER_NEEDED CAR_YAKUZA
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_BLISTA
MARK_CAR_AS_NO_LONGER_NEEDED frank4_car1
MARK_CAR_AS_NO_LONGER_NEEDED frank4_car2

//SWITCH_WORLD_PROCESSING OFF
SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time


WHILE cs_time < 12345
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LRQC_1 ) 5000 1 // Mission brief

WHILE cs_time < 14476
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LRQC_2 ) 5000 1 // Mission brief

WHILE cs_time < 16021
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LRQC_3 ) 5000 1 // Mission brief

WHILE cs_time < 17946
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LRQC_4 ) 5000 1 // Mission brief

WHILE cs_time < 21438
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LRQC_5 ) 5000 1 // Mission brief

WHILE cs_time < 23312
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LRQC_6 ) 5000 1 // Mission brief

WHILE cs_time < 25177 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 28000 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1000 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

//SWITCH_WORLD_PROCESSING ON
SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_IN_FRONT_OF_PLAYER
//SET_CAMERA_BEHIND_PLAYER

WAIT 500

DO_FADE 1000 FADE_IN 


UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ3
RELEASE_WEATHER
}

GOTO mission_frank4_passed


 // Mission frank4 failed

mission_frank4_failed:
	PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
RETURN

   
// mission frank4 passed

mission_frank4_passed:
flag_frankie_mission4_passed = 1
flag_industrial_passed = 1
PLAY_MISSION_PASSED_TUNE 1
INDUSTRIAL_PASSED
bridge_is_damaged = 1
	//SWAP BRIDGE FROM DAMAGED TO FIXED
	SWAP_NEAREST_BUILDING_MODEL	525.362 -927.066 71.841	20.0 nbbridgfk2	nbbridgcabls01
	SWAP_NEAREST_BUILDING_MODEL	706.432 -935.82  67.071	20.0 nbbridgfk2	nbbridgcabls01
	SWAP_NEAREST_BUILDING_MODEL	529.023 -920.098 43.504 20.0 damgbridgerdb nbbridgerdb
	SWAP_NEAREST_BUILDING_MODEL	702.763 -939.963 38.736	20.0 damgbridgerdb nbbridgerdb
	SWAP_NEAREST_BUILDING_MODEL	529.023 -942.94  43.504	20.0 damgbbridgerda	nbbridgerda
	SWAP_NEAREST_BUILDING_MODEL	702.764 -919.963 38.736	20.0 damgbbridgerda	nbbridgerda

	SWAP_NEAREST_BUILDING_MODEL	525.362 -927.066 71.841	20.0 lodridgfk2	lodridgcabls01
	SWAP_NEAREST_BUILDING_MODEL	706.432 -935.82  67.071	20.0 lodridgfk2	lodridgcabls01
	SWAP_NEAREST_BUILDING_MODEL	521.146 -922.94  43.504 20.0 lodgbridgerdb lodridgerdb
	SWAP_NEAREST_BUILDING_MODEL	702.763 -939.963 38.736	20.0 lodgbridgerdb lodridgerdb
	SWAP_NEAREST_BUILDING_MODEL	529.023 -940.098 43.504	20.0 lodgbbridgerda	lodridgerda
	SWAP_NEAREST_BUILDING_MODEL	702.764 -919.963 38.736	20.0 lodgbbridgerda	lodridgerda

	SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 1027.26 -933.796 15.042 50.0 indhelix_barrier FALSE 

	SWAP_NEAREST_BUILDING_MODEL 1027.26 -933.796 15.042 50.0 indhelix_barrier LOD_land014  

	DELETE_OBJECT subway_gate_industrial
	DELETE_OBJECT tunnel_gate_industrial

IF ammu2_blip_added = 0
	ADD_SPRITE_BLIP_FOR_COORD 345.5 -713.5 26.1 RADAR_SPRITE_WEAPON com_ammu_nation2
	ADD_SPRITE_BLIP_FOR_COORD 379.0 -493.8 25.2 RADAR_SPRITE_SPRAY com_sprayshop2
	ammu2_blip_added = 1
ENDIF

SWITCH_ROADS_ON 619.6 -911.5 45.0 834.3 -954.5 32.0 //Industrial to commercial Bridge
SWITCH_ROADS_ON 659.6 200.0 -20.0 945.8 147.5 5.0	//Tunnel
SWITCH_ROADS_ON 529.6 106.5 -30.0 581.4 65.7 0.0 //tunnel from commercial to intersection for sub and ind
REGISTER_MISSION_PASSED	FM4
PLAYER_MADE_PROGRESS 1			
SWITCH_CAR_GENERATOR com_car23 101
REMOVE_BLIP frankie_contact_blip
REMOVE_BLIP luigi_contact_blip
REMOVE_BLIP toni_contact_blip
REMOVE_BLIP joey_contact_blip
PRINT_WITH_NUMBER_BIG ( M_PASS ) 20000 5000 1 //"Mission Passed!"
ADD_SCORE player 20000
START_NEW_SCRIPT asuka_mission1_loop
REMOVE_BLIP asuka_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 523.7 -643.0 16.1 RADAR_SPRITE_ASUKA asuka_contact_blip  
RETURN
		

// mission cleanup

mission_cleanup_frank4:

flag_player_on_mission = 0
flag_player_on_frankie_mission = 0
REMOVE_BLIP blip1_fm4
REMOVE_BLIP blip2_fm4
REMOVE_BLIP blip3_fm4
REMOVE_BLIP boat_blip
RELEASE_WEATHER
MARK_MODEL_AS_NO_LONGER_NEEDED BOAT_REEFER 
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_CHEETAH
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_YAKUZA
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_BLISTA 
REMOVE_CHAR_ELEGANTLY maria
REMOVE_CHAR_ELEGANTLY asuka
//MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
MISSION_HAS_FINISHED
RETURN