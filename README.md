# meta-lx2k
SolidRun Honeycomb LX2K layer for OpenEmbedded/Yocto

## Available Machines

* honeycomb_lx2k

## Yocto (Poky) Quick Start

The current setup verified to work on builds for SD card images at DDR speed of 2666

```text
MACHINE=honeycomb_lx2k bitbake core-image-minimal
dd if=tmp/deploy/images/honeycomb_lx2k/core-image-minimal-honeycomb_lx2k.wic of=/dev/sda bs=512
```
