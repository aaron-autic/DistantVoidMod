package net.aaronautic.distantvoid.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.aaronautic.distantvoid.entity.animations.ModAnimationDefinitions;
import net.aaronautic.distantvoid.entity.custom.ShadowGolemEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ShadowGolemModel<T extends ShadowGolemEntity> extends HierarchicalModel<T> {
	private final ModelPart shadow_golem;
	private final ModelPart head;

	public ShadowGolemModel(ModelPart root) {
		this.shadow_golem = root.getChild("shadow_golem");
		this.head = shadow_golem.getChild("body").getChild("torso").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition shadow_golem = partdefinition.addOrReplaceChild("shadow_golem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = shadow_golem.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -34.0F, -2.0F));

		PartDefinition Arm2 = arms.addOrReplaceChild("Arm2", CubeListBuilder.create().texOffs(0, 79).addBox(-4.5F, 0.0F, -4.5F, 9.0F, 34.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(11.5F, 0.0F, -0.5F));

		PartDefinition Arm1 = arms.addOrReplaceChild("Arm1", CubeListBuilder.create().texOffs(65, 70).addBox(-4.5F, 0.0F, -4.5F, 9.0F, 34.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.5F, 0.0F, -0.5F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition belly = torso.addOrReplaceChild("belly", CubeListBuilder.create().texOffs(59, 38).addBox(-8.0F, -10.0F, -9.0F, 16.0F, 17.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.0F, -1.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -39.0F, 0.0F));

		PartDefinition Head_Upper = head.addOrReplaceChild("Head_Upper", CubeListBuilder.create(), PartPose.offset(0.5F, -0.2303F, -0.0809F));

		PartDefinition cube_r1 = Head_Upper.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, 1.8986F, -3.6923F, 19.0F, 7.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.2303F, 4.0809F, 2.7925F, 0.0F, 0.0F));

		PartDefinition Head_Lower = head.addOrReplaceChild("Head_Lower", CubeListBuilder.create().texOffs(0, 27).addBox(-8.5F, -3.0F, -21.0F, 17.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 3.0F, 8.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(ShadowGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.WALK_ANIMATION, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, ModAnimationDefinitions.IDLE_ANIMATION, ageInTicks, 1f);

	}
	private void applyHeadRotation(ShadowGolemEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		shadow_golem.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return shadow_golem;
	}
}