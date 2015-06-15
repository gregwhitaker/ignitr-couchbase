/*
 * Copyright 2015 Greg Whitaker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ignitr.couchbase;

import com.couchbase.client.java.AsyncBucket;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseBucket;
import com.couchbase.client.java.PersistTo;
import com.couchbase.client.java.ReplicaMode;
import com.couchbase.client.java.ReplicateTo;
import com.couchbase.client.java.bucket.BucketManager;
import com.couchbase.client.java.document.Document;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.JsonLongDocument;
import com.couchbase.client.java.query.Query;
import com.couchbase.client.java.query.QueryResult;
import com.couchbase.client.java.view.ViewQuery;
import com.couchbase.client.java.view.ViewResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IgnitrCouchbaseBucket implements Bucket {
    private static final Logger LOGGER = LoggerFactory.getLogger(IgnitrCouchbaseBucket.class);

    private CouchbaseBucket wrappedBucket;

    private CouchbaseBucket bucket() {
        return wrappedBucket;
    }

    @Override
    public AsyncBucket async() {
        return bucket().async();
    }

    @Override
    public String name() {
        return bucket().name();
    }

    @Override
    public JsonDocument get(String id) {
        return bucket().get(id);
    }

    @Override
    public JsonDocument get(String id, long timeout, TimeUnit timeUnit) {
        return bucket().get(id, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D get(D document) {
        return bucket().get(document);
    }

    @Override
    public <D extends Document<?>> D get(D document, long timeout, TimeUnit timeUnit) {
        return bucket().get(document, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D get(String id, Class<D> target) {
        return bucket().get(id, target);
    }

    @Override
    public <D extends Document<?>> D get(String id, Class<D> target, long timeout, TimeUnit timeUnit) {
        return bucket().get(id, target, timeout, timeUnit);
    }

    @Override
    public List<JsonDocument> getFromReplica(String id, ReplicaMode type) {
        return bucket().getFromReplica(id, type);
    }

    @Override
    public List<JsonDocument> getFromReplica(String id, ReplicaMode type, long timeout, TimeUnit timeUnit) {
        return bucket().getFromReplica(id, type, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> List<D> getFromReplica(D document, ReplicaMode type) {
        return bucket().getFromReplica(document, type);
    }

    @Override
    public <D extends Document<?>> List<D> getFromReplica(D document, ReplicaMode type, long timeout, TimeUnit timeUnit) {
        return bucket().getFromReplica(document, type, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> List<D> getFromReplica(String id, ReplicaMode type, Class<D> target) {
        return bucket().getFromReplica(id, type, target);
    }

    @Override
    public <D extends Document<?>> List<D> getFromReplica(String id, ReplicaMode type, Class<D> target, long timeout, TimeUnit timeUnit) {
        return bucket().getFromReplica(id, type, target, timeout, timeUnit);
    }

    @Override
    public JsonDocument getAndLock(String id, int lockTime) {
        return bucket().getAndLock(id, lockTime);
    }

    @Override
    public JsonDocument getAndLock(String id, int lockTime, long timeout, TimeUnit timeUnit) {
        return bucket().getAndLock(id, lockTime, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D getAndLock(D document, int lockTime) {
        return bucket().getAndLock(document, lockTime);
    }

    @Override
    public <D extends Document<?>> D getAndLock(D document, int lockTime, long timeout, TimeUnit timeUnit) {
        return bucket().getAndLock(document, lockTime, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D getAndLock(String id, int lockTime, Class<D> target) {
        return bucket().getAndLock(id, lockTime, target);
    }

    @Override
    public <D extends Document<?>> D getAndLock(String id, int lockTime, Class<D> target, long timeout, TimeUnit timeUnit) {
        return bucket().getAndLock(id, lockTime, target, timeout, timeUnit);
    }

    @Override
    public JsonDocument getAndTouch(String id, int expiry) {
        return bucket().getAndTouch(id, expiry);
    }

    @Override
    public JsonDocument getAndTouch(String id, int expiry, long timeout, TimeUnit timeUnit) {
        return bucket().getAndTouch(id, expiry, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D getAndTouch(D document) {
        return bucket().getAndTouch(document);
    }

    @Override
    public <D extends Document<?>> D getAndTouch(D document, long timeout, TimeUnit timeUnit) {
        return bucket().getAndTouch(document, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D getAndTouch(String id, int expiry, Class<D> target) {
        return bucket().getAndTouch(id, expiry, target);
    }

    @Override
    public <D extends Document<?>> D getAndTouch(String id, int expiry, Class<D> target, long timeout, TimeUnit timeUnit) {
        return bucket().getAndTouch(id, expiry, target, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D insert(D document) {
        return bucket().insert(document);
    }

    @Override
    public <D extends Document<?>> D insert(D document, long timeout, TimeUnit timeUnit) {
        return bucket().insert(document, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D insert(D document, PersistTo persistTo, ReplicateTo replicateTo) {
        return bucket().insert(document, persistTo, replicateTo);
    }

    @Override
    public <D extends Document<?>> D insert(D document, PersistTo persistTo, ReplicateTo replicateTo, long timeout, TimeUnit timeUnit) {
        return bucket().insert(document, persistTo, replicateTo, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D insert(D document, PersistTo persistTo) {
        return bucket().insert(document, persistTo);
    }

    @Override
    public <D extends Document<?>> D insert(D document, PersistTo persistTo, long timeout, TimeUnit timeUnit) {
        return bucket().insert(document, persistTo, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D insert(D document, ReplicateTo replicateTo) {
        return bucket().insert(document, replicateTo);
    }

    @Override
    public <D extends Document<?>> D insert(D document, ReplicateTo replicateTo, long timeout, TimeUnit timeUnit) {
        return bucket().insert(document, replicateTo, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D upsert(D document) {
        return bucket().upsert(document);
    }

    @Override
    public <D extends Document<?>> D upsert(D document, long timeout, TimeUnit timeUnit) {
        return bucket().upsert(document, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D upsert(D document, PersistTo persistTo, ReplicateTo replicateTo) {
        return bucket().upsert(document, persistTo, replicateTo);
    }

    @Override
    public <D extends Document<?>> D upsert(D document, PersistTo persistTo, ReplicateTo replicateTo, long timeout, TimeUnit timeUnit) {
        return bucket().upsert(document, persistTo, replicateTo, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D upsert(D document, PersistTo persistTo) {
        return bucket().upsert(document, persistTo);
    }

    @Override
    public <D extends Document<?>> D upsert(D document, PersistTo persistTo, long timeout, TimeUnit timeUnit) {
        return bucket().upsert(document, persistTo, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D upsert(D document, ReplicateTo replicateTo) {
        return bucket().upsert(document, replicateTo);
    }

    @Override
    public <D extends Document<?>> D upsert(D document, ReplicateTo replicateTo, long timeout, TimeUnit timeUnit) {
        return bucket().upsert(document, replicateTo, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D replace(D document) {
        return bucket().replace(document);
    }

    @Override
    public <D extends Document<?>> D replace(D document, long timeout, TimeUnit timeUnit) {
        return bucket().replace(document, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D replace(D document, PersistTo persistTo, ReplicateTo replicateTo) {
        return bucket().replace(document, persistTo, replicateTo);
    }

    @Override
    public <D extends Document<?>> D replace(D document, PersistTo persistTo, ReplicateTo replicateTo, long timeout, TimeUnit timeUnit) {
        return bucket().replace(document, persistTo, replicateTo, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D replace(D document, PersistTo persistTo) {
        return bucket().replace(document, persistTo);
    }

    @Override
    public <D extends Document<?>> D replace(D document, PersistTo persistTo, long timeout, TimeUnit timeUnit) {
        return bucket().replace(document, persistTo, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D replace(D document, ReplicateTo replicateTo) {
        return bucket().replace(document, replicateTo);
    }

    @Override
    public <D extends Document<?>> D replace(D document, ReplicateTo replicateTo, long timeout, TimeUnit timeUnit) {
        return bucket().replace(document, replicateTo, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D remove(D document) {
        return bucket().remove(document);
    }

    @Override
    public <D extends Document<?>> D remove(D document, long timeout, TimeUnit timeUnit) {
        return bucket().remove(document, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D remove(D document, PersistTo persistTo, ReplicateTo replicateTo) {
        return bucket().remove(document, persistTo, replicateTo);
    }

    @Override
    public <D extends Document<?>> D remove(D document, PersistTo persistTo, ReplicateTo replicateTo, long timeout, TimeUnit timeUnit) {
        return bucket().remove(document, persistTo, replicateTo, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D remove(D document, PersistTo persistTo) {
        return bucket().remove(document, persistTo);
    }

    @Override
    public <D extends Document<?>> D remove(D document, PersistTo persistTo, long timeout, TimeUnit timeUnit) {
        return bucket().remove(document, persistTo, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D remove(D document, ReplicateTo replicateTo) {
        return bucket().remove(document, replicateTo);
    }

    @Override
    public <D extends Document<?>> D remove(D document, ReplicateTo replicateTo, long timeout, TimeUnit timeUnit) {
        return bucket().remove(document, replicateTo, timeout, timeUnit);
    }

    @Override
    public JsonDocument remove(String id) {
        return bucket().remove(id);
    }

    @Override
    public JsonDocument remove(String id, long timeout, TimeUnit timeUnit) {
        return bucket().remove(id, timeout, timeUnit);
    }

    @Override
    public JsonDocument remove(String id, PersistTo persistTo, ReplicateTo replicateTo) {
        return bucket().remove(id, persistTo, replicateTo);
    }

    @Override
    public JsonDocument remove(String id, PersistTo persistTo, ReplicateTo replicateTo, long timeout, TimeUnit timeUnit) {
        return bucket().remove(id, persistTo, replicateTo, timeout, timeUnit);
    }

    @Override
    public JsonDocument remove(String id, PersistTo persistTo) {
        return bucket().remove(id, persistTo);
    }

    @Override
    public JsonDocument remove(String id, PersistTo persistTo, long timeout, TimeUnit timeUnit) {
        return bucket().remove(id, persistTo, timeout, timeUnit);
    }

    @Override
    public JsonDocument remove(String id, ReplicateTo replicateTo) {
        return bucket().remove(id, replicateTo);
    }

    @Override
    public JsonDocument remove(String id, ReplicateTo replicateTo, long timeout, TimeUnit timeUnit) {
        return bucket().remove(id, replicateTo, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D remove(String id, Class<D> target) {
        return bucket().remove(id, target);
    }

    @Override
    public <D extends Document<?>> D remove(String id, Class<D> target, long timeout, TimeUnit timeUnit) {
        return bucket().remove(id, target, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D remove(String id, PersistTo persistTo, ReplicateTo replicateTo, Class<D> target) {
        return bucket().remove(id, persistTo, replicateTo, target);
    }

    @Override
    public <D extends Document<?>> D remove(String id, PersistTo persistTo, ReplicateTo replicateTo, Class<D> target, long timeout, TimeUnit timeUnit) {
        return bucket().remove(id, persistTo, replicateTo, target, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D remove(String id, PersistTo persistTo, Class<D> target) {
        return bucket().remove(id, persistTo, target);
    }

    @Override
    public <D extends Document<?>> D remove(String id, PersistTo persistTo, Class<D> target, long timeout, TimeUnit timeUnit) {
        return bucket().remove(id, persistTo, target, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D remove(String id, ReplicateTo replicateTo, Class<D> target) {
        return bucket().remove(id, replicateTo, target);
    }

    @Override
    public <D extends Document<?>> D remove(String id, ReplicateTo replicateTo, Class<D> target, long timeout, TimeUnit timeUnit) {
        return bucket().remove(id, replicateTo, target, timeout, timeUnit);
    }

    @Override
    public ViewResult query(ViewQuery query) {
        return bucket().query(query);
    }

    @Override
    public ViewResult query(ViewQuery query, long timeout, TimeUnit timeUnit) {
        return bucket().query(query, timeout, timeUnit);
    }

    @Override
    public QueryResult query(Query query) {
        return bucket().query(query);
    }

    @Override
    public QueryResult query(Query query, long timeout, TimeUnit timeUnit) {
        return bucket().query(query, timeout, timeUnit);
    }

    @Override
    public QueryResult query(String query) {
        return bucket().query(query);
    }

    @Override
    public QueryResult query(String query, long timeout, TimeUnit timeUnit) {
        return bucket().query(query, timeout, timeUnit);
    }

    @Override
    public Boolean unlock(String id, long cas) {
        return bucket().unlock(id, cas);
    }

    @Override
    public Boolean unlock(String id, long cas, long timeout, TimeUnit timeUnit) {
        return bucket().unlock(id, cas, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> Boolean unlock(D document) {
        return bucket().unlock(document);
    }

    @Override
    public <D extends Document<?>> Boolean unlock(D document, long timeout, TimeUnit timeUnit) {
        return bucket().unlock(document, timeout, timeUnit);
    }

    @Override
    public Boolean touch(String id, int expiry) {
        return bucket().touch(id, expiry);
    }

    @Override
    public Boolean touch(String id, int expiry, long timeout, TimeUnit timeUnit) {
        return bucket().touch(id, expiry, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> Boolean touch(D document) {
        return bucket().touch(document);
    }

    @Override
    public <D extends Document<?>> Boolean touch(D document, long timeout, TimeUnit timeUnit) {
        return bucket().touch(document, timeout, timeUnit);
    }

    @Override
    public JsonLongDocument counter(String id, long delta) {
        return bucket().counter(id, delta);
    }

    @Override
    public JsonLongDocument counter(String id, long delta, long timeout, TimeUnit timeUnit) {
        return bucket().counter(id, delta, timeout, timeUnit);
    }

    @Override
    public JsonLongDocument counter(String id, long delta, long initial) {
        return bucket().counter(id, delta, initial);
    }

    @Override
    public JsonLongDocument counter(String id, long delta, long initial, long timeout, TimeUnit timeUnit) {
        return bucket().counter(id, delta, initial, timeout, timeUnit);
    }

    @Override
    public JsonLongDocument counter(String id, long delta, long initial, int expiry) {
        return bucket().counter(id, delta, initial, expiry);
    }

    @Override
    public JsonLongDocument counter(String id, long delta, long initial, int expiry, long timeout, TimeUnit timeUnit) {
        return bucket().counter(id, delta, initial, expiry, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D append(D document) {
        return bucket().append(document);
    }

    @Override
    public <D extends Document<?>> D append(D document, long timeout, TimeUnit timeUnit) {
        return bucket().append(document, timeout, timeUnit);
    }

    @Override
    public <D extends Document<?>> D prepend(D document) {
        return bucket().prepend(document);
    }

    @Override
    public <D extends Document<?>> D prepend(D document, long timeout, TimeUnit timeUnit) {
        return bucket().prepend(document, timeout, timeUnit);
    }

    @Override
    public BucketManager bucketManager() {
        return bucket().bucketManager();
    }

    @Override
    public Boolean close() {
        return bucket().close();
    }

    @Override
    public Boolean close(long timeout, TimeUnit timeUnit) {
        return bucket().close(timeout, timeUnit);
    }
}
