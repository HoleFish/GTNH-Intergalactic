package galaxyspace.core.recipe;

import static gregtech.api.enums.GT_Values.RA;
import static net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE;

import com.dreammaster.item.ItemList;

import galaxyspace.BarnardsSystem.BRBlocks;
import galaxyspace.core.register.GSBlocks;
import galaxyspace.core.register.GSItems;
import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

public class CraftingRecipes {

    public static void loadRecipes() {

        //Assembler
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.glass), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Desh, 8)}, null, new ItemStack(GSBlocks.FutureGlass, 1, 0), 200, 480);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(GCItems.battery, 1, WILDCARD_VALUE), GT_Utility.getIntegratedCircuit(1)}, FluidRegistry.getFluidStack("molten.lead", 6000), new ItemStack(GSItems.LeadBattery, 1, 100), 100, 120);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(GSItems.ThermalPaddingTier2), GT_Utility.getIntegratedCircuit(1)}, null, new ItemStack(GSItems.ThermalClothTier2, 5), 360, 1024);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(GSItems.ThermalPaddingTier2, 1, 1), GT_Utility.getIntegratedCircuit(1)}, null, new ItemStack(GSItems.ThermalClothTier2, 8), 600, 1024);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(GSItems.ThermalPaddingTier2, 1, 2), GT_Utility.getIntegratedCircuit(1)}, null, new ItemStack(GSItems.ThermalClothTier2, 7), 520, 1024);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(GSItems.ThermalPaddingTier2, 1, 3), GT_Utility.getIntegratedCircuit(1)}, null, new ItemStack(GSItems.ThermalClothTier2, 4), 300, 1024);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(AsteroidsItems.basicItem, 1, 7), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Titanium, 8), ItemList.TungstenString.getIS(8), GT_Utility.getIntegratedCircuit(1)}, FluidRegistry.getFluidStack("molten.polybenzimidazole", 576), new ItemStack(GSItems.ThermalClothTier2), 600, 1024);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(GSItems.ThermalClothTier2, 5), ItemList.TungstenString.getIS(5), GT_Utility.getIntegratedCircuit(5)}, FluidRegistry.getFluidStack("molten.polybenzimidazole", 1440), new ItemStack(GSItems.ThermalPaddingTier2), 1500, 1920);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(GSItems.ThermalClothTier2, 8), ItemList.TungstenString.getIS(8), GT_Utility.getIntegratedCircuit(8)}, FluidRegistry.getFluidStack("molten.polybenzimidazole", 2304), new ItemStack(GSItems.ThermalPaddingTier2, 1, 1), 2400, 1920);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(GSItems.ThermalClothTier2, 7), ItemList.TungstenString.getIS(7), GT_Utility.getIntegratedCircuit(7)}, FluidRegistry.getFluidStack("molten.polybenzimidazole", 2016), new ItemStack(GSItems.ThermalPaddingTier2, 1, 2), 2100, 1920);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(GSItems.ThermalClothTier2, 4), ItemList.TungstenString.getIS(4), GT_Utility.getIntegratedCircuit(4)}, FluidRegistry.getFluidStack("molten.polybenzimidazole", 1152), new ItemStack(GSItems.ThermalPaddingTier2, 1, 3), 1200, 1920);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(GSItems.SpacesuitHelmet), new ItemStack(GCItems.sensorGlasses)}, FluidRegistry.getFluidStack("molten.duralumin", 1440), new ItemStack(GSItems.SpacesuitHelmetGlasses), 600, 1920);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(GSItems.SpacesuitPlate), GT_ModHandler.getModItem("IC2", "itemArmorJetpackElectric", 1, WILDCARD_VALUE)}, FluidRegistry.getFluidStack("molten.duralumin", 1440), new ItemStack(GSItems.SpacesuitJetPlate), 600, 1920);
        RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(GSItems.SpacesuitBoots), new ItemStack(GSItems.CompressedPlates, 2, 4)}, FluidRegistry.getFluidStack("molten.duralumin", 1440), new ItemStack(GSItems.SpacesuitGravityBoots), 600, 1920);

        //Autoclave
        RA.addAutoclaveRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1), FluidRegistry.getFluidStack("water", 1000), new ItemStack(GSItems.UnknowCrystal), 9000, 3600, 480);
        RA.addAutoclaveRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1), FluidRegistry.getFluidStack("ic2distilledwater", 1000), new ItemStack(GSItems.UnknowCrystal), 10000, 2400, 480);

        //Circuit Assembler
        RA.addCircuitAssemblerRecipe(new ItemStack[]{new ItemStack(GCItems.heavyPlatingTier1), ItemList.SchematicsTier1.getIS(), GT_OreDictUnificator.get("oc:keyboard", 1), ItemList.Display.getIS(), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32682), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32692)}, FluidRegistry.getFluidStack("molten.solderingalloy", 576), new ItemStack(GSItems.ControlComputer, 1, 1), 600, 480, true);
        RA.addCircuitAssemblerRecipe(new ItemStack[]{new ItemStack(MarsItems.marsItemBasic, 1, 3), ItemList.SchematicsTier2.getIS(), GT_OreDictUnificator.get("oc:keyboard", 1), ItemList.Display.getIS(), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32682), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32692)}, FluidRegistry.getFluidStack("molten.solderingalloy", 576), new ItemStack(GSItems.ControlComputer, 1, 2), 600, 480, true);
        RA.addCircuitAssemblerRecipe(new ItemStack[]{new ItemStack(AsteroidsItems.basicItem), ItemList.SchematicsTier3.getIS(), GT_OreDictUnificator.get("oc:keyboard", 1), ItemList.Display.getIS(), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32683), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32693)}, FluidRegistry.getFluidStack("molten.solderingalloy", 576), new ItemStack(GSItems.ControlComputer, 1, 3), 600, 1920, true);
        RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.HeavyDutyPlateTier4.getIS(), ItemList.SchematicsTier4.getIS(), GT_OreDictUnificator.get("oc:keyboard", 1), ItemList.Display.getIS(), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32684), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32694)}, FluidRegistry.getFluidStack("molten.solderingalloy", 576), new ItemStack(GSItems.ControlComputer, 1, 4), 600, 7680, true);
        RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.HeavyDutyPlateTier5.getIS(), ItemList.SchematicsTier5.getIS(), GT_OreDictUnificator.get("oc:keyboard", 1), ItemList.Display.getIS(), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32685), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32695)}, FluidRegistry.getFluidStack("molten.solderingalloy", 576), new ItemStack(GSItems.ControlComputer, 1, 5), 600, 30720, true);
        RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.HeavyDutyPlateTier6.getIS(), ItemList.SchematicsTier6.getIS(), GT_OreDictUnificator.get("oc:keyboard", 1), ItemList.Display.getIS(), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32685), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32695)}, FluidRegistry.getFluidStack("molten.solderingalloy", 576), new ItemStack(GSItems.ControlComputer, 1, 6), 600, 30720, true);
        RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.HeavyDutyPlateTier7.getIS(), ItemList.SchematicsTier7.getIS(), GT_OreDictUnificator.get("oc:keyboard", 1), ItemList.Display.getIS(), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32686), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32696)}, FluidRegistry.getFluidStack("molten.solderingalloy", 576), new ItemStack(GSItems.ControlComputer, 1, 7), 600, 122880, true);
        RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.HeavyDutyPlateTier8.getIS(), ItemList.SchematicsTier8.getIS(), GT_OreDictUnificator.get("oc:keyboard", 1), ItemList.Display.getIS(), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32687), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32697)}, FluidRegistry.getFluidStack("molten.solderingalloy", 576), new ItemStack(GSItems.ControlComputer, 1, 8), 600, 491520, true);
        RA.addCircuitAssemblerRecipe(new ItemStack[]{new ItemStack(GCItems.heavyPlatingTier1), ItemList.SchematicsMoonBuggy.getIS(), new ItemStack(GCItems.basicItem, 1, 14), GT_OreDictUnificator.get("circuitData", 1), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32682), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32692)}, FluidRegistry.getFluidStack("molten.solderingalloy", 576), new ItemStack(GSItems.ControlComputer, 1, 100), 600, 480, true);
        RA.addCircuitAssemblerRecipe(new ItemStack[]{new ItemStack(MarsItems.marsItemBasic, 1, 3), ItemList.SchematicsCargoRocket.getIS(), new ItemStack(GCItems.basicItem, 1, 14), GT_OreDictUnificator.get("circuitElite", 1), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32683), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32693)}, FluidRegistry.getFluidStack("molten.solderingalloy", 576), new ItemStack(GSItems.ControlComputer, 1, 101), 600, 1920, true);
        RA.addCircuitAssemblerRecipe(new ItemStack[]{new ItemStack(AsteroidsItems.basicItem), ItemList.SchematicsAstroMiner.getIS(), new ItemStack(GCItems.basicItem, 1, 14), GT_OreDictUnificator.get("circuitMaster", 1), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32684), GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32694)}, FluidRegistry.getFluidStack("molten.solderingalloy", 576), new ItemStack(GSItems.ControlComputer, 1, 102), 600, 7680, true);

        //Compressor
        RA.addCompressorRecipe(new ItemStack(GSItems.GlowstoneDusts, 4), new ItemStack(GSBlocks.CeresGlowStone), 300, 2);
        RA.addCompressorRecipe(new ItemStack(GSItems.GlowstoneDusts, 4, 1), new ItemStack(GSBlocks.IoGlowStone), 300, 2);
        RA.addCompressorRecipe(new ItemStack(GSItems.GlowstoneDusts, 4, 2), new ItemStack(GSBlocks.EnceladusGlowStone), 300, 2);
        RA.addCompressorRecipe(new ItemStack(GSItems.GlowstoneDusts, 4, 3), new ItemStack(GSBlocks.ProteusBlocks), 300, 2);
        RA.addCompressorRecipe(new ItemStack(GSItems.GlowstoneDusts, 4, 4), new ItemStack(GSBlocks.PlutoGlowStone), 300, 2);

        //Printer
        RA.addPrinterRecipe(new ItemStack(GCItems.heavyPlatingTier1), FluidRegistry.getFluidStack("dye.chemical.dyeblue", 36), ItemList.SchematicsMoonBuggy.getIS(0), new ItemStack(GCItems.schematic), 200, 480);
        RA.addPrinterRecipe(new ItemStack(MarsItems.marsItemBasic, 1, 3), FluidRegistry.getFluidStack("dye.chemical.dyeblue", 72), ItemList.SchematicsTier2.getIS(0), new ItemStack(GCItems.schematic, 1, 1), 200, 480);
        RA.addPrinterRecipe(new ItemStack(AsteroidsItems.basicItem), FluidRegistry.getFluidStack("dye.chemical.dyeblue", 144), ItemList.SchematicsTier3.getIS(0), new ItemStack(MarsItems.schematic), 200, 1920);
        RA.addPrinterRecipe(new ItemStack(GCItems.meteoricIronIngot, 1, 1), FluidRegistry.getFluidStack("dye.chemical.dyeblue", 144), ItemList.SchematicsCargoRocket.getIS(0), new ItemStack(MarsItems.schematic, 1, 1), 200, 1920);
        RA.addPrinterRecipe(new ItemStack(MarsItems.marsItemBasic, 1, 5), FluidRegistry.getFluidStack("dye.chemical.dyeblue", 288), ItemList.SchematicsAstroMiner.getIS(0), new ItemStack(MarsItems.schematic, 1, 2), 200, 7680);
        RA.addPrinterRecipe(ItemList.HeavyDutyPlateTier4.getIS(), FluidRegistry.getFluidStack("dye.chemical.dyeblue", 288), ItemList.SchematicsTier4.getIS(0), new ItemStack(GSItems.Tier4Schematic), 200, 7680);
        RA.addPrinterRecipe(ItemList.HeavyDutyPlateTier5.getIS(), FluidRegistry.getFluidStack("dye.chemical.dyeblue", 576), ItemList.SchematicsTier5.getIS(0), new ItemStack(GSItems.Tier5Schematic), 200, 30720);
        RA.addPrinterRecipe(ItemList.HeavyDutyPlateTier6.getIS(), FluidRegistry.getFluidStack("dye.chemical.dyeblue", 1152), ItemList.SchematicsTier6.getIS(0), new ItemStack(GSItems.Tier6Schematic), 200, 30720);
        RA.addPrinterRecipe(ItemList.HeavyDutyPlateTier7.getIS(), FluidRegistry.getFluidStack("dye.chemical.dyeblue", 2304), ItemList.SchematicsTier7.getIS(0), new ItemStack(GSItems.Tier7Schematic), 200, 122880);
        RA.addPrinterRecipe(ItemList.HeavyDutyPlateTier8.getIS(), FluidRegistry.getFluidStack("dye.chemical.dyeblue", 4608), ItemList.SchematicsTier8.getIS(0), new ItemStack(GSItems.Tier8Schematic), 200, 491520);

        //Pulverization
        RA.addPulveriserRecipe(new ItemStack(GSBlocks.CeresGlowStone), new ItemStack[]{new ItemStack(GSItems.GlowstoneDusts, 4)}, new int[]{10000}, 300, 2);
        RA.addPulveriserRecipe(new ItemStack(GSBlocks.IoGlowStone), new ItemStack[]{new ItemStack(GSItems.GlowstoneDusts, 4, 1)}, new int[]{10000}, 300, 2);
        RA.addPulveriserRecipe(new ItemStack(GSBlocks.EnceladusGlowStone), new ItemStack[]{new ItemStack(GSItems.GlowstoneDusts, 4, 2)}, new int[]{10000}, 300, 2);
        RA.addPulveriserRecipe(new ItemStack(GSBlocks.ProteusGlowStone), new ItemStack[]{new ItemStack(GSItems.GlowstoneDusts, 4, 3)}, new int[]{10000}, 300, 2);
        RA.addPulveriserRecipe(new ItemStack(GSBlocks.PlutoGlowStone), new ItemStack[]{new ItemStack(GSItems.GlowstoneDusts, 4, 4)}, new int[]{10000}, 300, 2);

        //Shaped Crafting
        addDyedFutureGlassRecipe(0, "Black");
        addDyedFutureGlassRecipe(1, "Red");
        addDyedFutureGlassRecipe(2, "Green");
        addDyedFutureGlassRecipe(3, "Brown");
        addDyedFutureGlassRecipe(4, "Blue");
        addDyedFutureGlassRecipe(5, "Purple");
        addDyedFutureGlassRecipe(6, "Cyan");
        addDyedFutureGlassRecipe(7, "LightGray");
        addDyedFutureGlassRecipe(8, "Gray");
        addDyedFutureGlassRecipe(9, "Pink");
        addDyedFutureGlassRecipe(10, "Lime");
        addDyedFutureGlassRecipe(11, "Yellow");
        addDyedFutureGlassRecipe(12, "LightBlue");
        addDyedFutureGlassRecipe(13, "Magenta");
        addDyedFutureGlassRecipe(14, "Orange");
        addDyedFutureGlassRecipe(15, "White");
        addDecorativeMetalBlockRecipe(0, new ItemStack(GSItems.CompressedPlates, 1, 3));
        addDecorativeMetalBlockRecipe(1, new ItemStack(GSItems.CompressedPlates));
        addDecorativeMetalBlockRecipe(2, new ItemStack(GSItems.CompressedPlates, 1, 1));
        addDecorativeMetalBlockRecipe(3, new ItemStack(GSItems.CompressedPlates, 1, 4));
        addDecorativeMetalBlockRecipe(4, new ItemStack(GSItems.CompressedPlates, 1, 5));
        addDecorativeMetalBlockRecipe(5, new ItemStack(GSItems.CompressedPlates, 1, 6));
        addDecorativeMetalBlockRecipe(6, new ItemStack(GSItems.CompressedPlates, 1, 7));
        addDecorativeMetalBlockRecipe(7, new ItemStack(GSItems.CompressedPlates, 1, 8));
        addDecorativeMetalBlockRecipe(8, new ItemStack(GSItems.CompressedPlates, 1, 9));
        addDecorativeMetalBlockRecipe(9, new ItemStack(GCItems.basicItem, 1, 6));
        RecipeUtil.addRecipe(new ItemStack(GSBlocks.MachineFrames), new Object[]{"MWM", "CTC", "MWM", 'M', new ItemStack(GSItems.CompressedPlates, 1, 5), 'W', ItemList.WaferTier3.getIS(), 'C', new ItemStack(GCBlocks.aluminumWire, 1, 1), 'T', new ItemStack(GregTech_API.sBlockCasings4)});
        RecipeUtil.addRecipe(new ItemStack(GSBlocks.StorageModuleT3), new Object[]{"CEC", "WFW", "CEC", 'C', new ItemStack(GSItems.CompressedPlates, 1, 9), 'E', new ItemStack(GCBlocks.machineTiered, 1, 8), 'W', ItemList.WaferTier3.getIS(), 'F', new ItemStack(GSBlocks.MachineFrames)});
        RecipeUtil.addRecipe(new ItemStack(GSBlocks.OxStorageModuleT2), new Object[]{"SCS", "PFP", "SWS", 'S', new ItemStack(GCBlocks.machineBase2, 1, 8), 'C', new ItemStack(GCItems.oxygenConcentrator), 'P', new ItemStack(GCBlocks.oxygenPipe), 'F', new ItemStack(GSBlocks.MachineFrames), 'W', ItemList.WaferTier3.getIS()});
        RecipeUtil.addRecipe(new ItemStack(BRBlocks.BarnardaCPlanks, 4), new Object[]{"L", 'L', new ItemStack(BRBlocks.BarnardaCLog)}); //GT replaces this recipe automatically
        RecipeUtil.addRecipe(new ItemStack(GSItems.SpacesuitBoots), new Object[]{"ABA", "ADA", "CDC", 'A', new ItemStack(GSItems.CompressedSDHD120), 'B', new ItemStack(GSItems.LeadBoots), 'D', new ItemStack(MarsItems.marsItemBasic, 1, 5), 'C', new ItemStack(GSItems.CompressedPlates, 1, 2)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.QuantBow), new Object[]{"LMS", "m S", "LMS", 'L', GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Lead, 1), 'M', ItemList.MytrylCrystal.getIS(), 'S', GT_ModHandler.getModItem("TConstruct", "bowstring", 1, 2), 'm', ItemList.MysteriousCrystal.getIS()});
        RecipeUtil.addRecipe(new ItemStack(GSItems.LeadHelmet), new Object[]{"LLL", "LHL", "D D", 'L', new ItemStack(GSItems.CompressedPlates, 1, 3), 'H', "craftingToolHardHammer", 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.LeadPlate), new Object[]{"LHL", "LDL", "L L", 'L', new ItemStack(GSItems.CompressedPlates, 1, 3), 'H', "craftingToolHardHammer", 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.LeadLeg), new Object[]{"LLL", "LDL", "LHL", 'L', new ItemStack(GSItems.CompressedPlates, 1, 3), 'H', "craftingToolHardHammer", 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.LeadBoots), new Object[]{"D D", "LHL", "L L", 'L', new ItemStack(GSItems.CompressedPlates, 1, 3), 'H', "craftingToolHardHammer", 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.CobaltumHelmet), new Object[]{"CCC", "CHC", "D D", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H', "craftingToolHardHammer", 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.CobaltumPlate), new Object[]{"CHC", "CDC", "C C", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H', "craftingToolHardHammer", 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.CobaltumLeg), new Object[]{"CCC", "CDC", "CHC", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H', "craftingToolHardHammer", 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.CobaltumBoots), new Object[]{"D D", "CHC", "C C", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H', "craftingToolHardHammer", 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.SpacesuitHelmet), new Object[]{"AHA", "AMA", "DCD", 'A', new ItemStack(GSItems.CompressedSDHD120), 'H', new ItemStack(GSItems.LeadHelmet), 'M', new ItemStack(GCItems.oxMask), 'D', new ItemStack(MarsItems.marsItemBasic, 1, 5), 'C', new ItemStack(GCItems.oxygenConcentrator)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.SpacesuitPlate), new Object[]{"APA", "ACA", "ADA", 'A', new ItemStack(GSItems.CompressedSDHD120), 'P', new ItemStack(GSItems.LeadPlate), 'C', new ItemStack(GSItems.CompressedPlates, 1, 2), 'D', new ItemStack(MarsItems.marsItemBasic, 1, 5)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.SpacesuitLeg), new Object[]{"ALA", "CAC", "CDC", 'A', new ItemStack(GSItems.CompressedSDHD120), 'L', new ItemStack(GSItems.LeadLeg), 'C', new ItemStack(GSItems.CompressedPlates, 1, 2), 'D', new ItemStack(MarsItems.marsItemBasic, 1, 5)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.ModuleLander), new Object[]{"FSS", "SBC", "PEP", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'S', new ItemStack(GCItems.basicItem,  1, 9), 'B', new ItemStack(GCItems.partBuggy, 1, 1), 'C', new ItemStack(GCItems.basicItem, 1, 6), 'P', new ItemStack(GCItems.flagPole), 'E', new ItemStack(GCItems.rocketEngine)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.ModuleLanderT2), new Object[]{"FPF", "CLC", "FCF", 'F', GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1), 'P', new ItemStack(GCItems.parachute, 1, WILDCARD_VALUE), 'C', new ItemStack(GCItems.canvas), 'L', new ItemStack(GSItems.ModuleLander)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.ModuleLanderT3), new Object[]{"DDD", "PLP", "DDD", 'D', new ItemStack(MarsItems.marsItemBasic, 1, 5), 'P', new ItemStack(GCItems.flagPole), 'L', new ItemStack(GSItems.ModuleLanderT2)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.PlasmaSword, 1, 100), new Object[]{"DCD", "FCH", "DBW", 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'F', "craftingToolFile", 'H', "craftingToolHardHammer", 'B', new ItemStack(GCItems.battery, 1, WILDCARD_VALUE), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 1)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.PlasmaPickaxe, 1, 100), new Object[]{"CCC", "FPH", "DBW", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'F', "craftingToolFile", 'P', new ItemStack(GCItems.flagPole), 'H', "craftingToolHardHammer", 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'B', new ItemStack(GCItems.battery, 1, WILDCARD_VALUE), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 1)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.PlasmaAxe, 1, 100), new Object[]{"CCH", "CPD", "FBW", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H', "craftingToolHardHammer", 'P', new ItemStack(GCItems.flagPole), 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'F', "craftingToolFile", 'B', new ItemStack(GCItems.battery, 1, WILDCARD_VALUE), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 1)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.PlasmaShovel, 1, 100), new Object[]{"FCH", "DPD", "WBW", 'F', "craftingToolFile", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H', "craftingToolHardHammer", 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'P', new ItemStack(GCItems.flagPole), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 1), 'B', new ItemStack(GCItems.battery, 1, WILDCARD_VALUE)});
        RecipeUtil.addRecipe(new ItemStack(GSItems.PlasmaHoe, 1, 100), new Object[]{"CCH", "FPD", "WBD", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H', "craftingToolHardHammer", 'F', "craftingToolFile", 'P', new ItemStack(GCItems.flagPole), 'D', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 1), 'B', new ItemStack(GCItems.battery, 1, WILDCARD_VALUE)});
        RecipeUtil.addRecipe(new ItemStack(GCBlocks.nasaWorkbench), new Object[]{"RRR", "CAC", "PHP", 'R', GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1, 32652), 'C', "circuitElite", 'A', new ItemStack(GregTech_API.sBlockMachines, 1, 213), 'P', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1), 'H', new ItemStack(GregTech_API.sBlockMachines, 1, 13)});
        RecipeUtil.addRecipe(ItemList.RawSDHCAlloy.getIS(), new Object[]{"SDS", "BCA", "SHS", 'S', GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1), 'D', "craftingToolScrewDriver", 'B', new ItemStack(GSItems.CompressedDualBronze), 'C', new ItemStack(GSItems.CompressedCoal), 'A', new ItemStack(GSItems.CompressedDualAluminium), 'H', "craftingToolHardHammer"});
    }

    private static void addDyedFutureGlassRecipe(int meta, String color) {
        RecipeUtil.addRecipe(new ItemStack(GSBlocks.FutureGlasses, 8, meta), new Object[]{"GGG", "GDG", "GGG", 'G', new ItemStack(GSBlocks.FutureGlass), 'D', "dye" + color});
    }

    private static void addDecorativeMetalBlockRecipe(int meta, ItemStack plate) {
        RecipeUtil.addRecipe(new ItemStack(GSBlocks.MetalsBlock, 1, meta), new Object[]{"HP ", "PSP", " PW", 'H', "craftingToolHardHammer", 'P', plate, 'S', "stone", 'W', "craftingToolWrench"});
    }

}
