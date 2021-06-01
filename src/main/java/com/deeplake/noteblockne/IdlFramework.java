package com.deeplake.noteblockne;

import com.deeplake.noteblockne.blocks.tileEntity.TileEntityNoteBase;
import com.deeplake.noteblockne.gui.ModGuiElementLoader;
import com.deeplake.noteblockne.init.ModConfig;
import com.deeplake.noteblockne.init.ModRecipes;
import com.deeplake.noteblockne.init.ModSpawn;
import com.deeplake.noteblockne.init.RegistryHandler;
import com.deeplake.noteblockne.keys.KeyboardManager;
import com.deeplake.noteblockne.meta.MetaUtil;
import com.deeplake.noteblockne.network.NetworkHandler;
import com.deeplake.noteblockne.proxy.ProxyBase;
import com.deeplake.noteblockne.util.CommonDef;
import com.deeplake.noteblockne.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

import static com.deeplake.noteblockne.init.RegistryHandler.initRegistries;

//To let the player be a traveling god who plays yin-yang magic.

@Mod(modid = IdlFramework.MODID, name = IdlFramework.NAME, version = IdlFramework.VERSION)//dependencies = "required-after:Forge@[14.23.5.2705,)"
public class IdlFramework {
    public static final String MODID = "noteblockne";
    public static final String NAME = "Extended Noteblock";
    public static final String VERSION = "1.1.0";

    public static Logger logger;

    public static final boolean SHOW_WARN = true;

    @Mod.Instance
    public static IdlFramework instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static ProxyBase proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        RegistryHandler.preInitRegistries(event);
    }

    @EventHandler
    public static void Init(FMLInitializationEvent event) {
        ModRecipes.Init();
        RegisterTileEntity();
        initRegistries(event);
        new ModGuiElementLoader();
        if (!proxy.isServer())
        {
            KeyboardManager.init();
        }
        NetworkHandler.init();

		LogWarning("%s has finished its initializations", MODID);

	}

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Moved Spawning registry to last since forge doesn't auto-generate sub
        // "M' biomes until late
        if (ModConfig.SPAWN_CONF.SPAWN) {
            ModSpawn.registerSpawnList();
        }

        TrashTalking();

        RegistryHandler.postInitReg();
    }

    @EventHandler
    public static void serverInit(FMLServerStartingEvent event) {
        RegistryHandler.serverRegistries(event);
    }


    private void TrashTalking() {
        if (Loader.isModLoaded("idealland"))
        {
            IdlFramework.Log("I bow to my master, Idealland.");
        }

//        if (MetaUtil.isIRRLoaded) {
//            IdlFramework.Log("Item Renderer? Consider contributing to MCMod-dot-cn.");
//        } else {
//            //IdlFramework.Log("No Item Renderer found.");
//        }
    }

    private static void RegisterTileEntity() {
        GameRegistry.registerTileEntity(TileEntityNoteBase.class, new ResourceLocation(MODID, "noteblock_te"));

        //GameRegistry.registerTileEntity(TileEntityBuilderFarm.class, new ResourceLocation(MODID, "builder_farm_basic"));
        //GameRegistry.registerTileEntity(TileEntityBuilderOne.class, new ResourceLocation(MODID, "builder.builder_one"));
    }

    public static void LogWarning(String str, Object... args) {
        if (SHOW_WARN) {
            logger.warn(String.format(str, args));
        }
    }

    public static void LogWarning(String str) {
        if (SHOW_WARN) {
            logger.warn(str);
        }
    }

    public static void Log(String str) {
//        if (ModConfig.GeneralConf.LOG_ON)
//        {
        logger.info(str);
//        }
    }

    public static void Log(String str, Object... args) {
//        if (ModConfig.GeneralConf.LOG_ON)
//        {
        logger.info(String.format(str, args));
//        }
    }
}