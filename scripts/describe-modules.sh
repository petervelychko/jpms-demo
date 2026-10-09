#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."

for jar in \
  catalog/target/catalog-demo-1.0-SNAPSHOT.jar \
  orders/target/orders-demo-1.0-SNAPSHOT.jar \
  notifications/target/notifications-demo-1.0-SNAPSHOT.jar \
  app/target/app-demo-1.0-SNAPSHOT.jar \
  legacy-promotions/target/legacy-promotions-demo-1.0-SNAPSHOT.jar
do
  if [[ -f "$jar" ]]; then
    echo
    echo "=== $jar ==="
    jar --describe-module --file "$jar"
  fi
done
