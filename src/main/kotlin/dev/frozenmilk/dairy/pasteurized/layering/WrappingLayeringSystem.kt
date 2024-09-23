package dev.frozenmilk.dairy.pasteurized.layering

import dev.frozenmilk.dairy.core.util.supplier.logical.IEnhancedBooleanSupplier
import dev.frozenmilk.dairy.core.util.supplier.numeric.IEnhancedNumericSupplier
import dev.frozenmilk.dairy.pasteurized.PasteurizedGamepad

/**
 * this incrementing layering system will wrap around when [next] and [previous] are called on it
 *
 * @see ListLayeringSystem
 */
class WrappingLayeringSystem<N : IEnhancedNumericSupplier<Double>, B : IEnhancedBooleanSupplier<B>, GAMEPAD: PasteurizedGamepad<N, B>> (private val list: List<GAMEPAD>) : IncrementingLayeringSystem<Int, N, B, GAMEPAD> {
	@SafeVarargs
	constructor(vararg gamepads: GAMEPAD) : this(gamepads.toList())
	init {
		list.forEach {
			attachGamepad(it)
		}
	}

	/**
	 * calling next at the last position will cause this layering system to wrap back around to the first position
	 */
	override fun next() {
		layer++
		layer %= list.size
		layer = layer.coerceIn(list.indices)
	}

	/**
	 * calling next at the first position will cause this layering system to wrap back around to the last position
	 */
	override fun previous() {
		layer--
		layer %= list.size
		if (layer < 0) layer += list.size
		layer = layer.coerceIn(list.indices)
	}

	override val gamepad: GAMEPAD?
		get() { return list.getOrNull(layer) }

	override var layer: Int = 0
}