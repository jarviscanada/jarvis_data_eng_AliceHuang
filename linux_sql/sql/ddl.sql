-- 1. switch to `host_agent`
\c host_agent;
-- 2. create `host_info` table if not exist
CREATE TABLE IF NOT EXISTS PUBLIC.host_info (
                                                id SERIAL NOT NULL,
                                                hostname VARCHAR NOT NULL,
                                                cpu_number INT NOT NULL,
                                                cpu_architecture VARCHAR NOT NULL,
                                                cpu_model VARCHAR NOT NULL,
                                                cpu_mhz DECIMAL(7, 3) NOT NULL,
    L2_cache INT NOT NULL,
    total_mem INT NOT NULL,
    "timestamp" TIMESTAMP NOT NULL,
    CONSTRAINT host_info_pk PRIMARY KEY (id),
    CONSTRAINT UC_host_info UNIQUE (hostname)
    );
-- 3. create `host_usage` table if not exist
CREATE TABLE IF NOT EXISTS PUBLIC.host_usage (
                                                 "timestamp" TIMESTAMP NOT NULL,
                                                 host_id INT NOT NULL,
                                                 memory_free INT NOT NULL,
                                                 cpu_idle INT NOT NULL,
                                                 cpu_kernel INT NOT NULL,
                                                 disk_io INT NOT NULL,
                                                 disk_available INT NOT NULL,
                                                 CONSTRAINT host_info_id FOREIGN KEY (host_id) REFERENCES PUBLIC.host_info(id)
    );
