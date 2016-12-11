/*
 * The MIT License
 *
 * Copyright 2016 PoVALE Team.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package es.ucm.povale.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * Base ListEntity class. 
 * 
 * This entity represents the String type. 
 *
 * @author PoVALE Team
 */
public class ListEntity implements Entity{
    
    private List<Entity> list;

    public ListEntity(List<? extends Entity> list) {
        this.list = new LinkedList<>();
        this.list.addAll(list);
    }

    public List<Entity> getList() {
        return list;
        
    }
    
    public boolean addEntity(Entity e){
        return list.add(e);
    }
    
    @Override
    public Class<? extends Entity> getType() {
        return  ListEntity.class;
    }
}
