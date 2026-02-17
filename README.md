# Minecraft Fabric Mod Template (1.21.11 / Loader 0.18.4)

This repository is a starter template for building a Fabric mod targeting:

- **Minecraft**: `1.21.11`
- **Fabric Loader**: `0.18.4`
- **Java**: `21`

## Included baseline behavior

The baseline client mod implements a toggle-driven state machine bound to the `]` key:

- States: `INITIALIZING`, `STARTING`, `IDLE`, `STOPPING`, `STOPPED`
- Default values on launch:
  - Toggle: `OFF`
  - State: `INITIALIZING`

State machine behavior by loop:

1. `INITIALIZING` -> logs entry, then moves to `STARTING`
2. `STARTING` -> logs entry, turns toggle `ON`, then moves to `IDLE`
3. `IDLE` -> logs entry, pressing `]` moves to `STOPPING`
4. `STOPPING` -> logs entry, turns toggle `OFF`, then moves to `STOPPED`
5. `STOPPED` -> logs entry, pressing `]` moves to `STARTING`

## Logging behavior

The template includes logging helpers that write to the local Minecraft client logs (log file / console), not in-game chat:

- State transitions (via `setState` helper)
- Toggle changes (`ON` / `OFF`)
- Entry into each state loop

## Quick start

```bash
./gradlew build
```

Run the client in dev mode:

```bash
./gradlew runClient
```

## Project structure

- `src/main/java` - common mod initializer
- `src/client/java` - client-only state machine, keybinding, and logging helpers
- `src/main/resources/fabric.mod.json` - mod metadata
- `docs/` - additional setup and usage docs

See `docs/SETUP.md` for version and customization notes.
