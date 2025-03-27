package com.ATsuNya3.examination.event;

import com.ATsuNya3.examination.Item.MessageItem;
import com.ATsuNya3.examination.MessageRecorde;
import com.ATsuNya3.examination.block.MessageBlock;
import com.ATsuNya3.examination.network.MyData;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import static com.ATsuNya3.examination.Examination.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME)
public class ForgeEventSubscriber {
    @SubscribeEvent
    public static void ProcessInfo(PlayerInteractEvent.RightClickBlock event){
        Player player = event.getEntity();
        ItemStack stack = player.getMainHandItem();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        if (state.getBlock() instanceof MessageBlock && stack.getItem() instanceof MessageItem){
            String message = ((MessageItem) stack.getItem()).getmessage();//
            PacketDistributor.sendToAllPlayers(new MyData(message));//发送给所有玩家

            event.getEntity().displayClientMessage(
                    Component.literal("成功")
                            .withStyle(ChatFormatting.DARK_PURPLE),
                    true
            );

        }else if (state.getBlock() instanceof MessageBlock && stack.isEmpty()){
            event.getEntity().displayClientMessage(
                    Component.literal(MessageRecorde.getLastMessage())
                            .withStyle(ChatFormatting.DARK_AQUA),
                    true
            );
        }
    }
//    @SubscribeEvent
//    public static void onRenderHUD(RenderGuiEvent.Post event) {
//        Minecraft minecraft = Minecraft.getInstance();
//        Player player = minecraft.player;
//
//        BlockHitResult hitResult = (BlockHitResult) player.pick(5.0, 0, false);
//        BlockState state = minecraft.level.getBlockState(hitResult.getBlockPos());
//
//        if(state.getBlock().getName() == MessageRecorder && state.isEmpty()){
//            String latestMessage = MessageRecorde.getLastMessage();
//            PrintStringAboveCross.PrintStringAboveCross(event.getGuiGraphics(),latestMessage);
//        }
//    }
}
