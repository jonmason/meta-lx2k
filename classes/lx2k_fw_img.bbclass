inherit image_types

# SD card image name
FWIMG = "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.fw.img"

#FIXME - need to know SD or SPI
BL2_SYMLINK ?= "bl2_sd.pbl"
#FIXME this is unique to SD
BL2_OFFSET ?= "8"
FIP_SYMLINK ?= "fip.bin"
FIP_OFFSET ?= "2048"
FIP_DDR_SYMLINK ?= "fip_ddr_all.bin"
FIP_DDR_OFFSET ?= "16384"
#FIXME this is version specific
MC_SYMLINK ?= "mc_10.20.4_lx2160a.itb"
MC_OFFSET ?= "20480"
#FIXME both of these are specific to the config of the networking
DPL_SYMLINK ?= "dpl-eth.8x10g.19.dtb"
DPL_OFFSET ?= "26624"
DPC_SYMLINK ?= "dpc-8_x_usxgmii.dtb"
DPC_OFFSET ?= "28672"


IMAGE_CMD_lx2k_fw_img () {
	dd if=${DEPLOY_DIR_IMAGE}/${BL2_SYMLINK} of=${FWIMG} bs=512 seek=${BL2_OFFSET} conv=notrunc
	dd if=${DEPLOY_DIR_IMAGE}/${FIP_SYMLINK} of=${FWIMG} bs=512 seek=${FIP_OFFSET} conv=notrunc
	dd if=${DEPLOY_DIR_IMAGE}/${FIP_DDR_SYMLINK} of=${FWIMG} bs=512 seek=${FIP_DDR_OFFSET} conv=notrunc
	dd if=${DEPLOY_DIR_IMAGE}/${MC_SYMLINK} of=${FWIMG} bs=512 seek=${MC_OFFSET} conv=notrunc
	dd if=${DEPLOY_DIR_IMAGE}/${DPL_SYMLINK} of=${FWIMG} bs=512 seek=${DPL_OFFSET} conv=notrunc
	dd if=${DEPLOY_DIR_IMAGE}/${DPC_SYMLINK} of=${FWIMG} bs=512 seek=${DPC_OFFSET} conv=notrunc
}

#IMAGE_CMD_disk.img = "lx2k_fw_img"
IMAGE_TYPES += ".fw.img"
