package com.minecraft7771.gtnhintergalactic.recipe;

import static gregtech.api.util.GT_ModHandler.getModItem;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.github.bartimaeusnek.bartworks.common.loaders.ItemRegistry;
import com.github.technus.tectech.thing.CustomItemList;
import com.minecraft7771.gtnhintergalactic.gui.IG_UITextures;
import com.minecraft7771.gtnhintergalactic.spaceprojects.ProjectAsteroidOutpost;

import galaxyspace.core.register.GSBlocks;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.TierEU;
import gregtech.common.misc.spaceprojects.SpaceProjectManager;
import gregtech.common.misc.spaceprojects.base.SP_Requirements;
import gregtech.common.misc.spaceprojects.base.SP_Upgrade;
import gregtech.common.misc.spaceprojects.base.SpaceProject;
import gregtech.common.misc.spaceprojects.enums.SolarSystem;
import gregtech.common.misc.spaceprojects.interfaces.ISpaceProject;

public class SpaceProjectRegistration implements Runnable {

    Fluid solderUEV = FluidRegistry.getFluid("molten.mutatedlivingsolder") != null
            ? FluidRegistry.getFluid("molten.mutatedlivingsolder")
            : FluidRegistry.getFluid("molten.solderingalloy");

    Fluid solderLuV = FluidRegistry.getFluid("molten.indalloy140") != null
            ? FluidRegistry.getFluid("molten.indalloy140")
            : FluidRegistry.getFluid("molten.solderingalloy");

    @Override
    public void run() {
        registerAsteroidOutpost();
        registerPlanetScan();
    }

    private void registerAsteroidOutpost() {
        ISpaceProject.ISP_Upgrade reinforcedStructure = new SP_Upgrade().setUpgradeName("ReinforcedStructure")
                .setUpgradeUnlocalizedName("gs.sp.upgrade.reinforcedstructure").setUpgradeTotalStages(40)
                .setUpgradeVoltage(TierEU.RECIPE_UHV).setUpgradeBuildTime(500 * 20)
                .setUpgradeItemsCost(
                        getModItem("supersolarpanel", "AdminSolarPanel", 1L, 0),
                        // Neutronium Borosilicate Glass
                        new ItemStack(ItemRegistry.bw_realglas, 24, 5),
                        getModItem("OpenComputers", "item", 8, 103),
                        CustomItemList.Machine_Multi_Computer.get(1),
                        ItemList.Sensor_UHV.get(1),
                        ItemList.Emitter_UHV.get(1))
                .setUpgradeFluidsCost(new FluidStack(solderLuV, 144 * 30));
        ISpaceProject.ISP_Upgrade improvedComputation = new SP_Upgrade().setUpgradeName("ImprovedComputation")
                .setUpgradeUnlocalizedName("gs.sp.upgrade.improvedcomputation").setUpgradeTotalStages(20)
                .setUpgradeVoltage(TierEU.RECIPE_UEV).setUpgradeBuildTime(750 * 20)
                .setUpgradeRequirements(new SP_Requirements().setUpgrades(reinforcedStructure))
                .setUpgradeItemsCost(
                        getModItem("supersolarpanel", "PhotonicSolarPanel", 1L, 0),
                        getModItem("OpenComputers", "item", 32, 103),
                        // Cosmic Neutronium Borosilicate Glass
                        new ItemStack(ItemRegistry.bw_realglas, 32, 14),
                        CustomItemList.Machine_Multi_Computer.get(16),
                        ItemList.Sensor_UEV.get(1),
                        ItemList.Emitter_UEV.get(1))
                .setUpgradeFluidsCost(new FluidStack(solderUEV, 144 * 10));
        ISpaceProject asteroidOutpost = new ProjectAsteroidOutpost().setProjectName("AsteroidOutpost")
                .setProjectUnlocalizedName("gs.spaceproject.asteroidoutpost")
                .setProjectUpgrades(reinforcedStructure, improvedComputation)
                .setProjectRequirements(new SP_Requirements().setSpaceBodyType(SolarSystem.KuiperBelt.getType()))
                .setProjectBuildTime(250 * 20).setProjectStages(40).setProjectVoltage(TierEU.RECIPE_UV)
                .setProjectTexture(IG_UITextures.PICTURE_SPACE_PROJECT_ASTEROID_OUTPOST).setProjectItemsCost(
                        // Osmium Borosilicate Glass
                        new ItemStack(ItemRegistry.bw_realglas, 16, 5),
                        // Ultra High Strength Concrete
                        new ItemStack(GSBlocks.DysonSwarmBlocks, 32, 9),
                        getModItem("supersolarpanel", "SingularSolarPanel", 1L, 0),
                        ItemList.Block_NeutroniumPlate.get(16),
                        ItemList.Sensor_UV.get(1),
                        ItemList.Emitter_UV.get(1))
                .setProjectFluidsCost(new FluidStack(solderLuV, 144 * 20));

        SpaceProjectManager.addProject(asteroidOutpost);
    }

    private void registerPlanetScan() {
        ISpaceProject planetScan = new SpaceProject().setProjectName("PlanetScan")
                .setProjectUnlocalizedName("gs.spaceproject.planetscan").setProjectBuildTime(250 * 20)
                .setProjectTexture(IG_UITextures.PICTURE_SPACE_PROJECT_PLANETARY_SCAN).setProjectStages(8)
                .setProjectVoltage(TierEU.RECIPE_UV).setProjectItemsCost(
                        // Osmium Borosilicate Glass
                        new ItemStack(ItemRegistry.bw_realglas, 8, 5),
                        ItemList.Block_NeutroniumPlate.get(4),
                        ItemList.Sensor_UV.get(2),
                        ItemList.Emitter_UV.get(2))
                .setProjectFluidsCost(new FluidStack(solderLuV, 144 * 20));

        SpaceProjectManager.addProject(planetScan);
    }
}
