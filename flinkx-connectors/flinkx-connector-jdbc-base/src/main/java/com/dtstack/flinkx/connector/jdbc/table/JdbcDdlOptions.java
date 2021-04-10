/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dtstack.flinkx.connector.jdbc.table;

import org.apache.flink.configuration.ConfigOption;
import org.apache.flink.configuration.ConfigOptions;

import java.time.Duration;

/**
 * Copy from flink 1.12 source
 * @program: flinkx
 * @author: wuren
 * @create: 2021/03/23
 **/
public class JdbcDdlOptions {
    private JdbcDdlOptions() {}

    public static final ConfigOption<String> URL =
            ConfigOptions.key("url")
                    .stringType()
                    .noDefaultValue()
                    .withDescription("the jdbc database url.");
    public static final ConfigOption<String> TABLE_NAME =
            ConfigOptions.key("table-name")
                    .stringType()
                    .noDefaultValue()
                    .withDescription("the jdbc table name.");
    public static final ConfigOption<String> USERNAME =
            ConfigOptions.key("username")
                    .stringType()
                    .noDefaultValue()
                    .withDescription("the jdbc user name.");
    public static final ConfigOption<String> PASSWORD =
            ConfigOptions.key("password")
                    .stringType()
                    .noDefaultValue()
                    .withDescription("the jdbc password.");
    public static final ConfigOption<String> DRIVER =
            ConfigOptions.key("driver")
                    .stringType()
                    .noDefaultValue()
                    .withDescription(
                            "the class name of the JDBC driver to use to connect to this URL. "
                                    + "If not set, it will automatically be derived from the URL.");

    // read config options
    public static final ConfigOption<String> SCAN_PARTITION_COLUMN =
            ConfigOptions.key("scan.partition.column")
                    .stringType()
                    .noDefaultValue()
                    .withDescription("the column name used for partitioning the input.");
    public static final ConfigOption<Integer> SCAN_PARTITION_NUM =
            ConfigOptions.key("scan.partition.num")
                    .intType()
                    .noDefaultValue()
                    .withDescription("the number of partitions.");
    public static final ConfigOption<Long> SCAN_PARTITION_LOWER_BOUND =
            ConfigOptions.key("scan.partition.lower-bound")
                    .longType()
                    .noDefaultValue()
                    .withDescription("the smallest value of the first partition.");
    public static final ConfigOption<Long> SCAN_PARTITION_UPPER_BOUND =
            ConfigOptions.key("scan.partition.upper-bound")
                    .longType()
                    .noDefaultValue()
                    .withDescription("the largest value of the last partition.");
    public static final ConfigOption<Integer> SCAN_FETCH_SIZE =
            ConfigOptions.key("scan.fetch-size")
                    .intType()
                    .defaultValue(0)
                    .withDescription(
                            "gives the reader a hint as to the number of rows that should be fetched, from"
                                    + " the database when reading per round trip. If the value specified is zero, then the hint is ignored. The"
                                    + " default value is zero.");
    public static final ConfigOption<Boolean> SCAN_AUTO_COMMIT =
            ConfigOptions.key("scan.auto-commit")
                    .booleanType()
                    .defaultValue(true)
                    .withDescription(
                            "sets whether the driver is in auto-commit mode. The default value is true, per"
                                    + " the JDBC spec.");

    // write config options
    public static final ConfigOption<Integer> SINK_BUFFER_FLUSH_MAX_ROWS =
            ConfigOptions.key("sink.buffer-flush.max-rows")
                    .intType()
                    .defaultValue(100)
                    .withDescription(
                            "the flush max size (includes all append, upsert and delete records), over this number"
                                    + " of records, will flush data. The default value is 100.");
    public static final ConfigOption<Duration> SINK_BUFFER_FLUSH_INTERVAL =
            ConfigOptions.key("sink.buffer-flush.interval")
                    .durationType()
                    .defaultValue(Duration.ofSeconds(1))
                    .withDescription(
                            "the flush interval mills, over this time, asynchronous threads will flush data. The "
                                    + "default value is 1s.");
    public static final ConfigOption<Integer> SINK_MAX_RETRIES =
            ConfigOptions.key("sink.max-retries")
                    .intType()
                    .defaultValue(3)
                    .withDescription("the max retry times if writing records to database failed.");

}
