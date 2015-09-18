/*
 * Copyright 2015 Joao Paulo Fernandes Ventura.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jpventura.popularmovies.domain.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.jpventura.popularmovies.domain.content.DomainSyncAdapter;

public class DomainSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static DomainSyncAdapter sDomainSyncAdapter = null;

    @Override
    public void onCreate() {
        synchronized (sSyncAdapterLock) {
            if (sDomainSyncAdapter == null) {
                sDomainSyncAdapter = new DomainSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sDomainSyncAdapter.getSyncAdapterBinder();
    }
}
