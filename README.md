# FirstJoinCommand

**FirstJoinCommand** 是一个可以自动在玩家第一次进入服务器时，执行指定的一连串指令的小工具，原理很简单，仅供自用，如有兴趣也可以尝试。只有一个配置文件 `config.yml`

```yaml
commands:
    - "lp user %username% parent add new" # 将所有进入服务器的玩家设置继承 `new` 组权限
    - "say 欢迎加入本服务器~" # 第一次入服的欢迎信息
    - # ...more
```

目前支持的 placeholder 有两个，一个是 `%username%`，表示玩家的用户名。一个是 `%uuid%`，表示玩家的 UUID。可直接在配置文件中使用。

## Plans

在将来会加入 Placeholder API 支持和其它可以基于该插件进行拓展的功能，暂时没有想到。同时会加入 `fjc enable` 和 `fjc disable` 指令在线控制插件是否启用。

## Compile

**参考**

- 编写时使用的 Paper API 是 `spigot-api-1.15.2-R0.1-20200410.011959-86.jar`
- 编写时使用的 Java 是 `java 11.0.6 2020-01-14 LTS`

**编译**

本项目使用 gradle，要进行编译，直接 `clone` 后执行 `./gradlew.bat build`（Windows 环境）或 `./gradlew build`（Linux 环境）即可。

## 协议

MIT