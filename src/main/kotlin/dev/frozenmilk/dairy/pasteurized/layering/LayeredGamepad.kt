package dev.frozenmilk.dairy.pasteurized.layering

import dev.frozenmilk.dairy.core.util.supplier.logical.IEnhancedBooleanSupplier
import dev.frozenmilk.dairy.core.util.supplier.numeric.IEnhancedNumericSupplier
import dev.frozenmilk.dairy.pasteurized.PasteurizedGamepad
import dev.frozenmilk.util.modifier.Modifier

@Suppress("INAPPLICABLE_JVM_NAME")
class LayeredGamepad<N : IEnhancedNumericSupplier<Double>, B : IEnhancedBooleanSupplier<B>, GAMEPAD: PasteurizedGamepad<N, B>>(var layeringSystem: LayeringSystem<*, N, B, GAMEPAD>) : PasteurizedGamepad<N, B> {
	private val err by lazy { IllegalStateException("layering system was unable to supply a gamepad") }
	override fun convert(n: N, modifier: Modifier<Double>): N = layeringSystem.gamepad?.convert(n, modifier) ?: throw err
	@get:JvmName("leftStickX")
	@set:JvmName("leftStickX")
	override var leftStickX: N
		get() { return layeringSystem.gamepad?.leftStickX ?: throw err }
		set(value) { layeringSystem.gamepad?.leftStickX = value }
	@get:JvmName("leftStickY")
	@set:JvmName("leftStickY")
	override var leftStickY: N
		get() { return layeringSystem.gamepad?.leftStickY ?: throw err }
		set(value) { layeringSystem.gamepad?.leftStickY = value }
	@get:JvmName("rightStickX")
	@set:JvmName("rightStickX")
	override var rightStickX: N
		get() { return layeringSystem.gamepad?.rightStickX ?: throw err }
		set(value) { layeringSystem.gamepad?.rightStickX = value }
	@get:JvmName("rightStickY")
	@set:JvmName("rightStickY")
	override var rightStickY: N
		get() { return layeringSystem.gamepad?.rightStickY ?: throw err }
		set(value) { layeringSystem.gamepad?.rightStickY = value }
	@get:JvmName("dpadUp")
	@set:JvmName("dpadUp")
	override var dpadUp: B
		get() { return layeringSystem.gamepad?.dpadUp ?: throw err }
		set(value) { layeringSystem.gamepad?.dpadUp = value }
	@get:JvmName("dpadDown")
	@set:JvmName("dpadDown")
	override var dpadDown: B
		get() { return layeringSystem.gamepad?.dpadDown ?: throw err }
		set(value) { layeringSystem.gamepad?.dpadDown = value }
	@get:JvmName("dpadLeft")
	@set:JvmName("dpadLeft")
	override var dpadLeft: B
		get() { return layeringSystem.gamepad?.dpadLeft ?: throw err }
		set(value) { layeringSystem.gamepad?.dpadLeft = value }
	@get:JvmName("dpadRight")
	@set:JvmName("dpadRight")
	override var dpadRight: B
		get() { return layeringSystem.gamepad?.dpadRight ?: throw err }
		set(value) { layeringSystem.gamepad?.dpadRight = value }
	@get:JvmName("a")
	@set:JvmName("a")
	override var a: B
		get() { return layeringSystem.gamepad?.a ?: throw err }
		set(value) { layeringSystem.gamepad?.a = value }
	@get:JvmName("b")
	@set:JvmName("b")
	override var b: B
		get() { return layeringSystem.gamepad?.b ?: throw err }
		set(value) { layeringSystem.gamepad?.b = value }
	@get:JvmName("x")
	@set:JvmName("x")
	override var x: B
		get() { return layeringSystem.gamepad?.x ?: throw err }
		set(value) { layeringSystem.gamepad?.x = value }
	@get:JvmName("y")
	@set:JvmName("y")
	override var y: B
		get() { return layeringSystem.gamepad?.y ?: throw err }
		set(value) { layeringSystem.gamepad?.y = value }
	@get:JvmName("guide")
	@set:JvmName("guide")
	override var guide: B
		get() { return layeringSystem.gamepad?.guide ?: throw err }
		set(value) { layeringSystem.gamepad?.guide = value }
	@get:JvmName("start")
	@set:JvmName("start")
	override var start: B
		get() { return layeringSystem.gamepad?.start ?: throw err }
		set(value) { layeringSystem.gamepad?.start = value }
	@get:JvmName("back")
	@set:JvmName("back")
	override var back: B
		get() { return layeringSystem.gamepad?.back ?: throw err }
		set(value) { layeringSystem.gamepad?.back = value }
	@get:JvmName("leftBumper")
	@set:JvmName("leftBumper")
	override var leftBumper: B
		get() { return layeringSystem.gamepad?.leftBumper ?: throw err }
		set(value) { layeringSystem.gamepad?.leftBumper = value }
	@get:JvmName("rightBumper")
	@set:JvmName("rightBumper")
	override var rightBumper: B
		get() { return layeringSystem.gamepad?.rightBumper ?: throw err }
		set(value) { layeringSystem.gamepad?.rightBumper = value }
	@get:JvmName("leftStickButton")
	@set:JvmName("leftStickButton")
	override var leftStickButton: B
		get() { return layeringSystem.gamepad?.leftStickButton ?: throw err }
		set(value) { layeringSystem.gamepad?.leftStickButton = value }
	@get:JvmName("rightStickButton")
	@set:JvmName("rightStickButton")
	override var rightStickButton: B
		get() { return layeringSystem.gamepad?.rightStickButton ?: throw err }
		set(value) { layeringSystem.gamepad?.rightStickButton = value }
	@get:JvmName("leftTrigger")
	@set:JvmName("leftTrigger")
	override var leftTrigger: N
		get() { return layeringSystem.gamepad?.leftTrigger ?: throw err }
		set(value) { layeringSystem.gamepad?.leftTrigger = value }
	@get:JvmName("rightTrigger")
	@set:JvmName("rightTrigger")
	override var rightTrigger: N
		get() { return layeringSystem.gamepad?.rightTrigger ?: throw err }
		set(value) { layeringSystem.gamepad?.rightTrigger = value }
	@get:JvmName("touchpad")
	@set:JvmName("touchpad")
	override var touchpad: B
		get() { return layeringSystem.gamepad?.touchpad ?: throw err }
		set(value) { layeringSystem.gamepad?.touchpad = value }
	@get:JvmName("touchpadFinger1")
	@set:JvmName("touchpadFinger1")
	override var touchpadFinger1: B
		get() { return layeringSystem.gamepad?.touchpadFinger1 ?: throw err }
		set(value) { layeringSystem.gamepad?.touchpadFinger1 = value }
	@get:JvmName("touchpadFinger2")
	@set:JvmName("touchpadFinger2")
	override var touchpadFinger2: B
		get() { return layeringSystem.gamepad?.touchpadFinger2 ?: throw err }
		set(value) { layeringSystem.gamepad?.touchpadFinger2 = value }
	@get:JvmName("touchpadFinger1X")
	@set:JvmName("touchpadFinger1X")
	override var touchpadFinger1X: N
		get() { return layeringSystem.gamepad?.touchpadFinger1X ?: throw err }
		set(value) { layeringSystem.gamepad?.touchpadFinger1X = value }
	override var touchpadFinger1Y
		get() = layeringSystem.gamepad?.touchpadFinger1Y ?: throw err
		set(value) { layeringSystem.gamepad?.touchpadFinger1Y = value }
	@get:JvmName("touchpadFinger2X")
	@set:JvmName("touchpadFinger2X")
	override var touchpadFinger2X: N
		get() { return layeringSystem.gamepad?.touchpadFinger2X ?: throw err }
		set(value) { layeringSystem.gamepad?.touchpadFinger2X = value }
	@get:JvmName("touchpadFinger2Y")
	@set:JvmName("touchpadFinger2Y")
	override var touchpadFinger2Y: N
		get() { return layeringSystem.gamepad?.touchpadFinger2Y ?: throw err }
		set(value) { layeringSystem.gamepad?.touchpadFinger2Y = value }
}
