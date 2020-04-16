# Changelog

## 2020/4/16

- 支持彩色字符，可使用 `&` 代替 `§` 编写彩色字。
- 支持启用、禁用、重载三个操作
  - `/fjc enable`
  - `/fjc disable`
  - `/fjc reload`
- 在 `config.yml` 中添加了 `enabled: boolean` 键，用于控制插件是否工作。

**提示** 旧版本升级后必须先手动执行 `/fjc enable` 才可使插件运作。