# Setup and customization

## Version pins

Pinned in `gradle.properties`:

- `minecraft_version=1.21.11`
- `loader_version=0.18.4`
- `loom_version=1.10-SNAPSHOT`
- `fabric_api_version=0.129.0+1.21.8`

If upstream artifact names change, update these values accordingly.

## Key implementation files

- `src/client/java/com/example/template/client/StateMachineTemplateClient.java`
  - keybinding (`]`)
  - toggle state tracking
  - state machine loop and transition helpers
  - local client log helper

- `src/main/java/com/example/template/StateMachineTemplateMod.java`
  - base mod initializer and shared logger

## Customizing the template

1. Rename package `com.example.template`.
2. Update mod metadata in `src/main/resources/fabric.mod.json`.
3. Update artifact/group names in `gradle.properties`.
4. Adjust state behavior in the client state machine as needed.
