DESCRIPTION = "DDR PHY Binary for NXP"
LICENSE = "Proprietary"

inherit deploy

SRC_URI = "git://github.com/NXP/ddr-phy-binary.git;protocol=https;nobranch=1"
SRCREV = "fbc036b88acb6c06ffed02c898cbae9856ec75ba"

LIC_FILES_CHKSUM = "file://README;md5=2b2ebcf79004f09c37fc79affccc8bbe"

S = "${WORKDIR}/git"

DEPENDS += "fiptool-native"

do_compile() {
	fiptool create --ddr-immem-udimm-1d lx2160a/ddr4_pmu_train_imem.bin --ddr-immem-udimm-2d lx2160a/ddr4_2d_pmu_train_imem.bin --ddr-dmmem-udimm-1d lx2160a/ddr4_pmu_train_dmem.bin --ddr-dmmem-udimm-2d lx2160a/ddr4_2d_pmu_train_dmem.bin --ddr-immem-rdimm-1d lx2160a/ddr4_rdimm_pmu_train_imem.bin --ddr-immem-rdimm-2d lx2160a/ddr4_rdimm2d_pmu_train_imem.bin --ddr-dmmem-rdimm-1d lx2160a/ddr4_rdimm_pmu_train_dmem.bin --ddr-dmmem-rdimm-2d lx2160a/ddr4_rdimm2d_pmu_train_dmem.bin fip_ddr_all.bin
}

do_deploy() {
        install -m 0644 ${S}/fip_ddr_all.bin ${DEPLOYDIR}/
}
addtask deploy before do_build after do_compile
