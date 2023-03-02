package com.minecraft7771.gtnhintergalactic.tile.multi.elevatormodules;

import com.github.technus.tectech.thing.metaTileEntity.multi.base.render.TT_RenderedExtendedFacingTexture;
import com.minecraft7771.gtnhintergalactic.block.BlockCasingSpaceElevator;
import com.minecraft7771.gtnhintergalactic.tile.multi.elevator.TileEntitySpaceElevator;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.github.technus.tectech.thing.metaTileEntity.multi.base.*;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;
import com.gtnewhorizon.structurelib.structure.StructureUtility;
import com.gtnewhorizons.modularui.api.screen.ModularWindow;
import com.gtnewhorizons.modularui.common.widget.*;

import com.minecraft7771.gtnhintergalactic.gui.IG_UITextures;
import com.minecraft7771.gtnhintergalactic.tile.multi.GT_MetaTileEntity_EnhancedMultiBlockBase_EM;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.util.GT_StructureUtility;
import gregtech.api.util.GT_Utility;

/**
 * Base class for modules of the Space Elevator
 *
 * @author minecraft7771
 */
public abstract class TileEntityModuleBase extends GT_MetaTileEntity_EnhancedMultiBlockBase_EM {

    /** Base size of the EU buffer at UV */
    protected static long EU_BUFFER_BASE_SIZE = 160008000L;
    /** Size of the EU buffer of this controller */
    protected final long euBufferSize;
    /** Tier of this controller (Voltage), which determines the recipes that it can execute */
    protected final int tTier;
    /** Module tier of this controller */
    protected final int tModuleTier;
    /** Minimum motor tier that is needed to run this module */
    protected final int tMinMotorTier;

    /** Output parameters */
    Parameters.Group.ParameterOut energyDisplay;

    /** Name of the stored energy display */
    private static final INameFunction<TileEntityModuleBase> ENERGY_DISPLAY_NAME = (base, p) -> GCCoreUtil
        .translate("gt.blockmachines.multimachine.project.gs.cfgo.0"); // Stored Energy
    /** Status of the stored energy display */
    private static final IStatusFunction<TileEntityModuleBase> ENERGY_STATUS = (base, p) -> LedStatus
        .fromLimitsInclusiveOuterBoundary(
            p.get(),
            1,
            (double) base.maxEUStore() / 2D,
            (double) base.maxEUStore() * 2D,
            (double) base.maxEUStore() * 2D);

    /** Name of the main structure piece */
    private static final String STRUCTURE_PIECE_MAIN = "main";
    /** Structure definition of this machine */
    private static final IStructureDefinition<TileEntityModuleBase> STRUCTURE_DEFINITION = StructureDefinition
        .<TileEntityModuleBase>builder()
        .addShape(
            STRUCTURE_PIECE_MAIN,
            StructureUtility.transpose(
                new String[][] { { "H", "H" }, { "~", "H" }, { "H", "H" }, { "H", "H" }, { "H", "H" } }))
        .addElement(
            'H',
            GT_StructureUtility.ofHatchAdderOptional(
                TileEntityModuleBase::addClassicToMachineList,
                TileEntitySpaceElevator.CASING_INDEX_BASE,
                1,
                BlockCasingSpaceElevator.INSTANCE,
                0))
        .build();

    /**
     * Create new project module base
     *
     * @param aID           ID of this module
     * @param aName         Name of this module
     * @param aNameRegional Localized name of this module
     * @param tTier         Tier of this module
     * @param tMinMotorTier Minimum needed motor tier
     */
    protected TileEntityModuleBase(int aID, String aName, String aNameRegional, int tTier, int tModuleTier,
                                   int tMinMotorTier) {
        super(aID, aName, aNameRegional);
        this.tTier = tTier;
        this.tModuleTier = tModuleTier;
        this.tMinMotorTier = tMinMotorTier;
        euBufferSize = EU_BUFFER_BASE_SIZE * (1L << (tTier - 7));
        useLongPower = true;
    }

    /**
     * Create new project module base
     *
     * @param aID                  ID of this module
     * @param aName                Name of this module
     * @param aNameRegional        Localized name of this module
     * @param tTier                Tier of this module
     * @param tMinMotorTier        Minimum needed motor tier
     * @param bufferSizeMultiplier Multiplier for the EU buffer size, if the standard buffer is too small
     */
    protected TileEntityModuleBase(int aID, String aName, String aNameRegional, int tTier, int tModuleTier,
                                   int tMinMotorTier, int bufferSizeMultiplier) {
        super(aID, aName, aNameRegional);
        this.tTier = tTier;
        this.tModuleTier = tModuleTier;
        this.tMinMotorTier = tMinMotorTier;
        euBufferSize = EU_BUFFER_BASE_SIZE * (1L << (tTier - 7)) * bufferSizeMultiplier;
        useLongPower = true;
    }

    /**
     * Create new project module base
     *
     * @param aName         Name of this module
     * @param tTier         Tier of this module
     * @param tMinMotorTier Minimum needed motor tier
     */
    protected TileEntityModuleBase(String aName, int tTier, int tModuleTier, int tMinMotorTier) {
        super(aName);
        this.tTier = tTier;
        this.tModuleTier = tModuleTier;
        this.tMinMotorTier = tMinMotorTier;
        euBufferSize = EU_BUFFER_BASE_SIZE * (1L << (tTier - 7));
        useLongPower = true;
    }

    /**
     * Create new project module base
     *
     * @param aName                Name of this module
     * @param tTier                Tier of this module
     * @param tMinMotorTier        Minimum needed motor tier
     * @param bufferSizeMultiplier Multiplier for the EU buffer size, if the standard buffer is too small
     */
    protected TileEntityModuleBase(String aName, int tTier, int tModuleTier, int tMinMotorTier,
                                   int bufferSizeMultiplier) {
        super(aName);
        this.tTier = tTier;
        this.tModuleTier = tModuleTier;
        this.tMinMotorTier = tMinMotorTier;
        euBufferSize = EU_BUFFER_BASE_SIZE * (1L << (tTier - 7)) * bufferSizeMultiplier;
        useLongPower = true;
    }

    /**
     * Callback that will be invoked on post tick
     *
     * @param aBaseMetaTileEntity This
     * @param aTick               Tick
     */
    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        if (aBaseMetaTileEntity.isServerSide()) {
            super.onPostTick(aBaseMetaTileEntity, aTick);
            if (aTick % 400 == 0) fixAllIssues();
            if (aTick % 20 == 0) energyDisplay.set(getEUVar());
            if (mEfficiency < 0) mEfficiency = 0;
            if (aBaseMetaTileEntity.getStoredEU() <= 0 && mMaxProgresstime > 0) {
                stopMachine();
            }
        }
    }

    /**
     * Drain the energy input of this controller (Which is its internal buffer in this case)
     *
     * @param EUtEffective Voltage
     * @param Amperes      Amperage
     * @return True if energy input could be drained, else false
     */
    @Override
    public boolean drainEnergyInput(long EUtEffective, long Amperes) {
        long EUuse = EUtEffective * Amperes;
        if (EUuse == 0L) {
            return true;
        } else {
            if (EUuse < 0L) {
                EUuse = -EUuse;
            }
            if (EUuse <= this.getEUVar()) {
                this.setEUVar(this.getEUVar() - EUuse);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Get the maximum EU that this controller can store
     *
     * @return Maximum EU that this controller can store
     */
    @Override
    public long maxEUStore() {
        return euBufferSize;
    }

    /**
     * Increase the EU stored in the controller buffer
     *
     * @param maximumIncrease EU that should be added to the buffer
     * @return Actually used amount
     */
    public long increaseStoredEU(long maximumIncrease) {
        if (getBaseMetaTileEntity() == null) {
            return 0;
        }
        long increasedEU = Math
            .min(getBaseMetaTileEntity().getEUCapacity() - getBaseMetaTileEntity().getStoredEU(), maximumIncrease);
        return getBaseMetaTileEntity().increaseStoredEnergyUnits(increasedEU, false) ? increasedEU : 0;
    }

    /**
     * Charge the energy buffer of the controller
     *
     * @param aBaseMetaTileEntity This
     */
    @Override
    protected void chargeController_EM(IGregTechTileEntity aBaseMetaTileEntity) {
        // Do nothing as we only receive energy from the Space Elevator controller
    }

    /**
     * Fix all maintenance issues of this controller
     */
    protected void fixAllIssues() {
        mWrench = true;
        mScrewdriver = true;
        mSoftHammer = true;
        mHardHammer = true;
        mSolderingTool = true;
        mCrowbar = true;
    }

    /**
     * Get the tier of the module
     *
     * @return Module tier
     */
    public int getTier() {
        return tTier;
    }

    /**
     * @return Motor tier that is necessary to run this module
     */
    public int getNeededMotorTier() {
        return tMinMotorTier;
    }

    /**
     * Get the maximum voltage that this elevator module can take in
     *
     * @return Voltage that corresponds to its tier
     */
    @Override
    public long getMaxInputVoltage() {
        return gregtech.api.enums.GT_Values.V[tTier];
    }

    /**
     * Get the structure of this elevator module. The structure is actually part of the elevator too and is only used to
     * map the busses and hatches to this module
     *
     * @return Structure definition
     */
    @Override
    public IStructureDefinition<? extends GT_MetaTileEntity_MultiblockBase_EM> getStructure_EM() {
        return STRUCTURE_DEFINITION;
    }

    /**
     * Construct the structure of this module
     *
     * @param stackSize Hologram projector item stack
     * @param hintsOnly Should only hints be displayed?
     */
    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        structureBuild_EM(STRUCTURE_PIECE_MAIN, 0, 1, 0, stackSize, hintsOnly);
    }

    /**
     * Check if the structure of this machine is valid
     *
     * @param aBaseMetaTileEntity This
     * @param aStack              Item stack present in the controller GUI
     * @return True if valid, else false
     */
    @Override
    public boolean checkMachine_EM(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        fixAllIssues();
        return structureCheck_EM(STRUCTURE_PIECE_MAIN, 0, 1, 0);
    }

    /**
     * Is this a simple machine?
     *
     * @return True
     */
    @Override
    public boolean isSimpleMachine() {
        return true;
    }

    /**
     * Will this machine explode in rain?
     *
     * @return False
     */
    @Override
    public boolean willExplodeInRain() {
        return false;
    }

    /**
     * Get the texture of this controller
     *
     * @param aBaseMetaTileEntity This
     * @param aSide               Side for which the texture will be gotten
     * @param aFacing             Facing side of the controller
     * @param aColorIndex         Color index
     * @param aActive             Flag if the controller is active
     * @param aRedstone           Flag if Redstone is present
     * @return Texture array of this controller
     */
    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex,
                                 boolean aActive, boolean aRedstone) {
        if (aSide == aFacing) {
            return new ITexture[] {
                Textures.BlockIcons.getCasingTextureForId(TileEntitySpaceElevator.CASING_INDEX_BASE),
                new TT_RenderedExtendedFacingTexture(
                    aActive ? GT_MetaTileEntity_MultiblockBase_EM.ScreenON
                        : GT_MetaTileEntity_MultiblockBase_EM.ScreenOFF) };
        }
        return new ITexture[] { Textures.BlockIcons.getCasingTextureForId(TileEntitySpaceElevator.CASING_INDEX_BASE) };
    }

    @Override
    public void addGregTechLogo(ModularWindow.Builder builder) {
        builder.widget(
            new DrawableWidget().setDrawable(IG_UITextures.PICTURE_ELEVATOR_LOGO_DARK).setSize(18, 18)
                .setPos(173, 74));
    }

    /**
     * Draw texts on the project module GUI
     *
     * @param screenElements Column that holds all screen elements
     * @param inventorySlot  Inventory slot of the controller
     */
    @Override
    protected void drawTexts(DynamicPositionedColumn screenElements, SlotWidget inventorySlot) {
        screenElements.setSynced(false).setSpace(0).setPos(10, 7);

        screenElements
            .widget(
                new TextWidget(GT_Utility.trans("138", "Incomplete Structure."))
                    .setDefaultColor(COLOR_TEXT_WHITE.get()).setEnabled(widget -> !mMachine))
            .widget(new FakeSyncWidget.BooleanSyncer(() -> mMachine, val -> mMachine = val));

        screenElements.widget(
            new TextWidget(StatCollector.translateToLocal("gt.blockmachines.multimachine.gs.elevator.gui.ready"))
                .setDefaultColor(COLOR_TEXT_WHITE.get()).setEnabled(widget -> mMachine));

        screenElements.widget(
            new TextWidget(StatCollector.translateToLocal("gt.blockmachines.multimachine.gs.elevator.gui.noRecipe"))
                .setDefaultColor(COLOR_TEXT_WHITE.get())
                .setEnabled(widget -> mMachine && !getBaseMetaTileEntity().isActive()));

        screenElements.widget(
            new TextWidget(StatCollector.translateToLocal("gt.blockmachines.multimachine.gs.elevator.gui.recipe"))
                .setDefaultColor(COLOR_TEXT_WHITE.get())
                .setEnabled(widget -> mMachine && getBaseMetaTileEntity().isActive()));
    }

    /**
     * Instantiate parameters of the controller
     */
    @Override
    protected void parametersInstantiation_EM() {
        Parameters.Group hatch_0 = parametrization.getGroup(0, false);
        energyDisplay = hatch_0.makeOutParameter(0, 0, ENERGY_DISPLAY_NAME, ENERGY_STATUS);
    }
}
