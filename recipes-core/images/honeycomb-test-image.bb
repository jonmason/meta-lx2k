# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL += " \
		vim-tiny \
		dropbear \
		lmsensors \
		pciutils \
		e2fsprogs \
		sysbench \
		phoronix-test-suite \
		"
