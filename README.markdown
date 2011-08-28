## ArmorSlots

Set of utilities to handle all your armor needs.

### Commands
- /hat
- /chestplate
- /leggings
- /boots
- /armor [type]

### Permissions
- armorslots.hat
- armorslots.chestplate
- armorslots.leggings
- armorslots.boots
- armorslots.firearmor (Allows fire armor)
- armorslots.diamondarmor (Allows diamond armor)
- armorslots.goldarmor (Allows gold armor)
- armorslots.ironarmor (Allows iron armor)
- armorslots.leatherarmor (Allows leather armor)
- armorslots.chainmailarmor (Allows chainmail armor)
- armorslots.fallboots (Allows no fall damage on gold boots)
- armorslots.void (Allows portal hat perks)
- armorslots.contact(Allows cactus hat perks)
- armorslots.attacked(Allows mobspawner hat perks)
- armorslots.scuba(Allows glass/pumpkin hat perks)
- armorslots.explosion(Allows TNT hat perks)

### Changelog:
#### 1.6. Sunday, August 28
- Added the '/armor' command. Allows the player to set a full set of armor.
- Changed '/firearmor' to '/armor fire'. Permission is still the same.

#### 1.5. Thursday, August 25
- Fixed the removal of entire stacks, sorta. Removes 1 from the stack if there's more than one, but if there's multiple stacks of the same amount, it will remove all of those stacks.

#### 1.4.1. Wednesday, August 24
- Removed Permissions 2.7/3 support. Now uses Bukkit SuperPerms. Use bPerms or PEX if you must.

#### 1.4. Sunday, July 24
- Added Bukkit SuperPerms support. (no need for a plugin -> Bukkit bridge)

#### 1.3. Saturday, July 16
- Added fire armor.
	- Immune to fire and lava damage.
- Added Permissions per damage nerf.

#### 1.2. Monday, July 11
- Added damage nerfs per hat equipped.
	- Portal blocks prevent Void damage.
	- Cactus blocks prevent contact damage. (touching cactus')
	- Glass & pumpkin blocks prevent drowning.
	- Mob Spawner blocks prevent ALL entity damage. (mobs, players)
	- TNT blocks prevent creeper explosion damage.
- Added damage nerfs per boots equipped.
	- Gold boots prevent fall damage.

#### 1.1. Thursday, July 7
- Changed command/permission from "chest" to "chestplate" (conflicted with other plugins)
- If you already have armor equipped, it now just swaps them around, not removing it completely.

#### 1.0. Sunday, July 3
- Initial release