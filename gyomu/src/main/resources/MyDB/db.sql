
CREATE TABLE `user_role` (
                             `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
                             `user_code` varchar(60) DEFAULT NULL,
                             `role_code` varchar(32) NOT NULL,
                             `role_name` varchar(32) DEFAULT NULL,
                             `ext_fld1` varchar(128) DEFAULT NULL,
                             `ext_fld2` varchar(128) DEFAULT NULL,
                             PRIMARY KEY (`user_role_id`),
                             KEY `idx_userCode` (`user_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=96930 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC


CREATE TABLE `role` (
                        `role_id` int(11) NOT NULL AUTO_INCREMENT,
                        `role_code` varchar(32) NOT NULL,
                        `role_name` varchar(32) DEFAULT NULL,
                        `role_name_kana` varchar(32) DEFAULT NULL,
                        `role_type` varchar(2) DEFAULT NULL,
                        `operator` varchar(60) DEFAULT NULL,
                        `ext_fld1` varchar(128) DEFAULT NULL,
                        `ext_fld2` varchar(128) DEFAULT NULL,
                        `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                        `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                        PRIMARY KEY (`role_id`),
                        KEY `idx_roleCode` (`role_code`) USING BTREE,
                        KEY `idx_roleType` (`role_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC


CREATE TABLE `user` (
                        `user_id` int(11) NOT NULL AUTO_INCREMENT,
                        `user_code` varchar(60) NOT NULL,
                        `user_name` varchar(60) DEFAULT NULL,
                        `user_level` varchar(2) DEFAULT NULL,
                        `user_pswd` varchar(32) DEFAULT NULL,
                        `user_status` varchar(2) DEFAULT NULL,
                        `lock_status` varchar(2) DEFAULT NULL,
                        `sex` varchar(12) DEFAULT NULL,
                        `phone` varchar(12) DEFAULT NULL,
                        `remark` varchar(128) DEFAULT NULL,
                        `operator` varchar(60) DEFAULT NULL,
                        `ext_fld1` varchar(128) DEFAULT NULL,
                        `ext_fld2` varchar(128) DEFAULT NULL,
                        `ext_fld3` varchar(128) DEFAULT NULL,
                        `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                        `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                        PRIMARY KEY (`user_id`),
                        UNIQUE KEY `uk_userCode` (`user_code`) USING BTREE,
) ENGINE=InnoDB AUTO_INCREMENT=86942 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC

