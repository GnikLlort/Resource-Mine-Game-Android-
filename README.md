# Resource-Mine-Game-Android
Resource Mine Game (Android) in Kotlin for Android Studio
Features
1. Resource Management
Manage five core resources: Water, Iron, Wood, Gold, and Helium-3.
2. Mines & Resource Generation
Each resource has a corresponding mine that auto-generates resources.
Base generation rate is 5 units per second, multiplied by the mine’s current level.
Mines can be upgraded to increase both resource generation and storage capacity.
3. Mine Upgrades
Each mine can be upgraded to a maximum level of 10.
Upgrade cost: 500 units of the respective resource.
Storage capacity increases by 500 units per level.
Mines stop generating when their storage is full.
4. Resource Storage
Starting storage capacity for each resource is 5000 units.
Storage capacity increases by 500 units for every mine upgrade.
5. Auto Resource Generation
Resources are generated automatically every second based on mine levels.
Generation stops when storage is full.
6. Dynamic User Interface (UI)
Real-time display of:
Resource amounts
Mine levels
Generation rates per second
Storage limits for each resource.
7. Upgrade System with Notifications
Upgrade mines by clicking dedicated buttons.
If resources are insufficient for an upgrade, a toast notification informs the player.
8. Data Persistence (SharedPreferences)
Game data (resources, levels) is automatically saved using SharedPreferences.
Resources and mine levels are restored upon re-launch.
9. Auto-Save
Resources and mine levels are auto-saved periodically during gameplay.
10. Notifications
Toast notifications when not enough resources are available for an upgrade.
