package dev.frozenmilk.dairy.pasteurized.layering

import dev.frozenmilk.dairy.core.util.supplier.logical.IEnhancedBooleanSupplier
import dev.frozenmilk.dairy.core.util.supplier.numeric.IEnhancedNumericSupplier
import dev.frozenmilk.dairy.pasteurized.PasteurizedGamepad

interface LayeringSystem<T, N : IEnhancedNumericSupplier<Double>, B : IEnhancedBooleanSupplier<B>, GAMEPAD: PasteurizedGamepad<N, B>> {
	/**
	 * the gamepad of the current layer
	 */
	val gamepad: GAMEPAD?
	var layer: T

	fun isActive(gamepad: GAMEPAD) = gamepad == this.gamepad

	/**
	 * attaches a gamepad to the layering system, which causes it to go to being at rest when not active in the system, once a gamepad has been attached to a layering system, it cannot be detached
	 */
	fun attachGamepad(gamepad: GAMEPAD) {
		val isActiveBoolean = { isActive(gamepad) }
		val isActiveNumber = { it: Double ->
			if (isActiveBoolean()) it
			else 0.0
		}

		gamepad.leftStickX = gamepad.convert(gamepad.leftStickX, isActiveNumber)
		gamepad.leftStickX = gamepad.convert(gamepad.leftStickX, isActiveNumber)
		gamepad.leftStickY = gamepad.convert(gamepad.leftStickY, isActiveNumber)
		gamepad.rightStickX = gamepad.convert(gamepad.rightStickX, isActiveNumber)
		gamepad.rightStickY = gamepad.convert(gamepad.rightStickY, isActiveNumber)

		gamepad.dpadUp = gamepad.dpadUp and isActiveBoolean
		gamepad.dpadDown = gamepad.dpadDown and isActiveBoolean
		gamepad.dpadLeft = gamepad.dpadLeft and isActiveBoolean
		gamepad.dpadRight = gamepad.dpadRight and isActiveBoolean

		gamepad.a = gamepad.a and isActiveBoolean
		gamepad.b = gamepad.b and isActiveBoolean
		gamepad.x = gamepad.x and isActiveBoolean
		gamepad.y = gamepad.y and isActiveBoolean

		gamepad.guide = gamepad.guide and isActiveBoolean
		gamepad.start = gamepad.start and isActiveBoolean
		gamepad.back = gamepad.back and isActiveBoolean

		gamepad.leftBumper = gamepad.leftBumper and isActiveBoolean
		gamepad.rightBumper = gamepad.rightBumper and isActiveBoolean

		gamepad.leftStickButton = gamepad.leftStickButton and isActiveBoolean
		gamepad.rightStickButton = gamepad.rightStickButton and isActiveBoolean

		gamepad.leftTrigger = gamepad.convert(gamepad.leftTrigger, isActiveNumber)
		gamepad.rightTrigger = gamepad.convert(gamepad.rightTrigger, isActiveNumber)

		gamepad.touchpad = gamepad.touchpad and isActiveBoolean
		gamepad.touchpadFinger1 = gamepad.touchpadFinger1 and isActiveBoolean
		gamepad.touchpadFinger2 = gamepad.touchpadFinger2 and isActiveBoolean

		gamepad.touchpadFinger1X = gamepad.convert(gamepad.touchpadFinger1X, isActiveNumber)
		gamepad.touchpadFinger1Y = gamepad.convert(gamepad.touchpadFinger1Y, isActiveNumber)
		gamepad.touchpadFinger2X = gamepad.convert(gamepad.touchpadFinger2X, isActiveNumber)
		gamepad.touchpadFinger2Y = gamepad.convert(gamepad.touchpadFinger2Y, isActiveNumber)
	}
}

interface IncrementingLayeringSystem<T, N : IEnhancedNumericSupplier<Double>, B : IEnhancedBooleanSupplier<B>, GAMEPAD: PasteurizedGamepad<N, B>> : LayeringSystem<T, N, B, GAMEPAD> {
	fun next()
	fun previous()
}
