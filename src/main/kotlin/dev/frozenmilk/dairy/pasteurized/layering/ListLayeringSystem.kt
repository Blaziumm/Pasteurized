package dev.frozenmilk.dairy.pasteurized.layering

import dev.frozenmilk.dairy.core.util.supplier.logical.IEnhancedBooleanSupplier
import dev.frozenmilk.dairy.core.util.supplier.numeric.IEnhancedNumericSupplier
import dev.frozenmilk.dairy.pasteurized.PasteurizedGamepad

class ListLayeringSystem<N : IEnhancedNumericSupplier<Double>, B : IEnhancedBooleanSupplier<B>, GAMEPAD: PasteurizedGamepad<N, B>> (private val list: List<GAMEPAD>) : IncrementingLayeringSystem<Int, N, B, GAMEPAD> {
	@SafeVarargs
	constructor(vararg gamepads: GAMEPAD) : this(gamepads.toList())
	init {
		list.forEach {
			attachGamepad(it)
		}
	}

	/**
	 * calling next at the last position will not cause this layering system to change
	 */
	override fun next() {
		layer++
		layer = layer.coerceIn(list.indices)
	}

	/**
	 * calling next at the first position will not cause this layering system to change
	 */
	override fun previous() {
		layer--
		layer = layer.coerceIn(list.indices)
	}

	override val gamepad: GAMEPAD?
		get() { return list.getOrNull(layer) }

	override var layer: Int = 0
}