/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.marsphotos.network

import com.example.marsphotos.model.MarsPhoto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * A public interface that exposes the [getPhotos] method
 */
interface MarsApiServiceInterface {
    suspend fun getPhotos(): List<MarsPhoto>
}

class MarsApiService(private val httpClient: HttpClient, private val baseUrl: String) :
    MarsApiServiceInterface {
    /**
     * Returns a [List] of [MarsPhoto] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "photos" endpoint will be requested with the GET
     * HTTP method
     */
    override suspend fun getPhotos() = httpClient.get("$baseUrl/photos").body<List<MarsPhoto>>()
}
