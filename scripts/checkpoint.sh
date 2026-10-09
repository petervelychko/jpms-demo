#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."

case "${1:-}" in
  00) tag=demo-00-classpath ;;
  01) tag=demo-01-catalog-module ;;
  02) tag=demo-02-encapsulation-failure ;;
  03) tag=demo-03-architecture-fixed ;;
  04) tag=demo-04-reflection-failure ;;
  05) tag=demo-05-opens-fixed ;;
  06) tag=demo-06-automatic-module ;;
  07) tag=demo-07-final ;;
  *)
    echo "Usage: $0 {00|01|02|03|04|05|06|07}" >&2
    exit 2
    ;;
esac

echo "Switching to $tag (discarding tracked live-demo edits)..."
git switch --detach --discard-changes "$tag"
echo "Now at $tag"
