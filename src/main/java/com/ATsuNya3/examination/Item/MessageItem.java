package com.ATsuNya3.examination.Item;

import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class MessageItem extends Item {
    private final String message;
    public MessageItem (Properties pProperties,String message){
        super(pProperties);
        this.message=message;
    }
    public String getmessage() {
        return message;
    }
}
