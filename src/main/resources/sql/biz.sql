CREATE TABLE `sys_file` (
    `id` bigint NOT NULL,
    `minio_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `local_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `uploader` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `uploadtime` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `file_size` mediumtext COLLATE utf8mb4_general_ci,
    `report_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `tb_source_code` (
    `id` bigint NOT NULL,
    `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `code_path` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `code_type` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `report_type` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `create_user` varchar(32) COLLATE utf8mb4_general_ci,
    `upload_time` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `tb_source_report` (
    `id` bigint NOT NULL,
    `source_id` bigint DEFAULT NULL,
    `report_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `file_path` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `uploadtime` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `desc` mediumtext COLLATE utf8mb4_general_ci,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `tb_check_mode` (
    `id` bigint NOT NULL,
    `mode_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;