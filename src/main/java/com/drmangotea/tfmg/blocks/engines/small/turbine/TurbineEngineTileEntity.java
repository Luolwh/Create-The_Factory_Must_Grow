package com.drmangotea.tfmg.blocks.engines.small.turbine;


import com.drmangotea.tfmg.blocks.engines.small.AbstractEngineTileEntity;
import com.drmangotea.tfmg.registry.TFMGBlocks;
import com.drmangotea.tfmg.registry.TFMGFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;

public class TurbineEngineTileEntity extends AbstractEngineTileEntity {


    public TurbineEngineTileEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);

    }

    @Override
    public boolean hasBackPart(){
        BlockPos wantedLocation=this.getBlockPos();
        Direction direction = this.getBlockState().getValue(DirectionalBlock.FACING);


        if(direction == Direction.UP)
            wantedLocation=this.getBlockPos().below();
        if(direction == Direction.DOWN)
            wantedLocation=this.getBlockPos().above();
        if(direction == Direction.NORTH)
            wantedLocation=this.getBlockPos().south();
        if(direction == Direction.SOUTH)
            wantedLocation=this.getBlockPos().north();
        if(direction == Direction.WEST)
            wantedLocation=this.getBlockPos().east();
        if(direction == Direction.EAST)
            wantedLocation=this.getBlockPos().west();



        if(!level.getBlockState(wantedLocation).is(TFMGBlocks.TURBINE_ENGINE_BACK.get())) {
            return false;
        }else {
            if ( level.getBlockState(wantedLocation).getValue(DirectionalBlock.FACING) != direction)
                return false;
        }
        return true;
    }
    @Override
    public Fluid validFuel() {
        return TFMGFluids.KEROSENE.getSource();
    }
}
