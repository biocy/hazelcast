/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.concurrent.lock;

import com.hazelcast.nio.serialization.Data;

import java.util.Set;

/**
 * @mdogan 2/12/13
 */
public interface LockStore {

    boolean lock(Data key, String caller, int threadId, long ttl);

    boolean extendTTL(Data key, String caller, int threadId, long ttl);

    boolean unlock(Data key, String caller, int threadId);

    boolean isLocked(Data key);

    boolean isLockedBy(Data key, String caller, int threadId);

    boolean canAcquireLock(Data key, String caller, int threadId);

    Set<Data> getLockedKeys();

    boolean forceUnlock(Data dataKey);
}