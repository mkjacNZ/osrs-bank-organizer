package com.bankorganizer;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.Item;
import net.runelite.api.InventoryID;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.client.game.ItemManager;


@Slf4j
@PluginDescriptor(
	name = "Bank Organizer"
)
public class BankOrganizerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private BankOrganizerConfig config;

	@Inject
	private ItemManager itemManager;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Bank Organizer started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Bank Organizer stopped!");
	}

	//@Subscribe
	//public void onGameStateChanged(GameStateChanged gameStateChanged)
	//{
		//if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		//{
		//	client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
		//}
	//}

//	Displays currently equipped weapon on equip
	/*@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.EQUIPMENT)) {
			Item[] items = event.getItemContainer().getItems();
			if (items != null && items.length > EquipmentInventorySlot.WEAPON.getSlotIdx()) {
				Item weaponItem = items[EquipmentInventorySlot.WEAPON.getSlotIdx()];
				if (weaponItem != null) {
					int itemId = weaponItem.getId();
					String weaponName = itemManager.getItemComposition(itemId).getName();

					// Extract other weapon properties as needed

					// Now you can use the weapon information to update your UI
					client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Your current equipped weapon is " + weaponName, null);
				}
			}
		}
	}*/

	@Provides
	BankOrganizerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BankOrganizerConfig.class);
	}
}
