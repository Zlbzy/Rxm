package com.eddy.rxm.admin.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class BatchOptObj {

    private Integer id;

    private String type;

    private List<Integer> optIds = new ArrayList();

    public void addOptId(Integer id){
        this.optIds.add(id);
    }

    public void removeOptId(Integer index){
        this.optIds.remove(index);
    }

    public void setOptIds(List<Integer> optIds){
        if(!this.optIds.isEmpty()) throw new UnsupportedOperationException("不支持该方法!");
        this.optIds.addAll(optIds);
    }

    public List<Integer> getOptIds(){
        return Collections.unmodifiableList(this.optIds);
    }
}
