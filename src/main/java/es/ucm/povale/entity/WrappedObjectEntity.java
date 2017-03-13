/*
 * Copyright (c) 2016. Grupo de Programación Declarativa - Universidad Complutense de Madrid
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.ucm.povale.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


/**
 * These are any entities for which we don't have specific support. This is
 * to be better-defined later on.
 *
 * @author Santiago Saavedra
 */
public final class WrappedObjectEntity<T> implements Entity {
    private final T wrapped;

    public WrappedObjectEntity(T wrapped) {
        this.wrapped = wrapped;
    }

    public final T get() {
        return wrapped;
    }

    /**
     * A Wrapped entity returns the underlying object's representation as a
     * String.
     *
     * @return object.get().toString()
     */
    public final String toString() {
        return wrapped.toString();
    }

    @Override
    public Class<? extends Entity> getType() {
        return  WrappedObjectEntity.class;
    }

    @Override
    public void toXML(Element contents, Document doc) {
        Text t = doc.createTextNode(this.toString());
        contents.appendChild(t);
    }
}
