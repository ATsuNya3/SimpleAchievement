package com.ATsuNya3.examination;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

import static com.ATsuNya3.examination.register.BlockRegister.BLOCKS;
import static com.ATsuNya3.examination.register.CreativeTabRegister.CREATIVE_TABS;
import static com.ATsuNya3.examination.register.ItemRegister.ITEMS;

@Mod(Examination.MODID)
public class Examination {
    public static final String MODID = "examination";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Examination(IEventBus modEventBus, ModContainer modContainer)
    {
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);
    }
}
