#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."
if [[ ! -f app/target/app-demo-1.0-SNAPSHOT.jar ]]; then
  echo "Build first with: ./scripts/build.sh" >&2
  exit 1
fi
java \
  --module-path "app/target/app-demo-1.0-SNAPSHOT.jar:app/target/modules" \
  --module dev.demo.app/dev.demo.app.Main
