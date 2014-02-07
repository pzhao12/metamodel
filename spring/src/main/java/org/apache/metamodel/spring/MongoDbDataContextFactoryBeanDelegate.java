/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.metamodel.spring;

import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.mongodb.MongoDbDataContext;
import org.apache.metamodel.util.SimpleTableDef;

/**
 * {@link DataContextFactoryBeanDelegate} for {@link MongoDbDataContext}.
 */
public class MongoDbDataContextFactoryBeanDelegate extends AbstractDataContextFactoryBeanDelegate {

    @Override
    public DataContext createDataContext(DataContextFactoryBean bean) {
        String hostname = bean.getHostname();
        Integer port = bean.getPort();
        String databaseName = bean.getDatabaseName();
        String username = bean.getUsername();
        char[] password = bean.getPassword().toCharArray();
        SimpleTableDef[] tableDefs = bean.getTableDefs();
        return DataContextFactory.createMongoDbDataContext(hostname, port, databaseName, username, password, tableDefs);
    }

}
