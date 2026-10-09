# Back to the Future with JPMS - Checkpointed Demo

A Java 25 / Maven project for **Back to the Future with JPMS: Modularizing Modern Java Applications**.

## Coordinates

- Group ID: `dev.demo`
- Parent artifact ID: `jpms-demo`
- Java: **25**
- Maven: 3.9+

Every Maven artifact ID ends in `-demo`.

## Why this ZIP includes `.git`

The Git history is part of the conference demo. After extracting the archive, these tags are immediately available:

```text
demo-00-classpath
demo-01-catalog-module
demo-02-encapsulation-failure
demo-03-architecture-fixed
demo-04-reflection-failure
demo-05-opens-fixed
demo-06-automatic-module
demo-07-final
```

The demo is organized as eight Git tags:

| Tag | Purpose |
| --- | --- |
| `demo-00-classpath` | Classpath baseline |
| `demo-01-catalog-module` | Catalog becomes the first named module |
| `demo-02-encapsulation-failure` | Intentional compile failure caused by access to Catalog internals |
| `demo-03-architecture-fixed` | Orders uses the public Catalog API |
| `demo-04-reflection-failure` | Intentional runtime failure caused by Jackson reflection |
| `demo-05-opens-fixed` | Reflection fixed with qualified `opens` |
| `demo-06-automatic-module` | Legacy promotions library is used as an automatic module |
| `demo-07-final` | Final working modular application |

Use `./scripts/checkpoint.sh 00` through `./scripts/checkpoint.sh 07` to switch between them.

## Final architecture

| Maven artifact | JPMS module | Role |
| --- | --- | --- |
| `catalog-demo` | `dev.demo.catalog` | Exported Catalog API + hidden implementation |
| `orders-demo` | `dev.demo.orders` | Order processing + Jackson reflection |
| `notifications-demo` | `dev.demo.notifications` | Consumer of Orders API |
| `app-demo` | `dev.demo.app` | Composition root |
| `legacy-promotions-demo` | automatic `dev.demo.promotions` | Deliberately lacks `module-info.java` |

## Build the final checkpoint

```bash
./scripts/build.sh
```

## Run the final checkpoint

```bash
./scripts/run-modulepath.sh
```

Expected shape:

```text
Java 25 | module: dev.demo.app
Persisted order as JSON: {"id":"...","total":34.02900}
Notification: order ... placed, total = 34.02900
```

## Stage helpers

```bash
./scripts/checkpoint.sh 02   # jump to the intentional encapsulation failure
./scripts/checkpoint.sh 05   # jump to the working opens example
./scripts/describe-modules.sh
```

`demo-02-encapsulation-failure` is intentionally uncompilable. `demo-04-reflection-failure` intentionally compiles but fails when run on the module path.
