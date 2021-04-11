package com.order.orderprovider.hadoop;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public interface Writable {

    void write(DataOutput output)throws IOException;
    void readFields(DataInput input)throws IOException;

}
