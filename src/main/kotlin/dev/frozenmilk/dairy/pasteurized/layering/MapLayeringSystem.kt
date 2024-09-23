package dev.frozenmilk.dairy.pasteurized.layering

import dev.frozenmilk.dairy.core.util.supplier.logical.IEnhancedBooleanSupplier
import dev.frozenmilk.dairy.core.util.supplier.numeric.IEnhancedNumericSupplier
import dev.frozenmilk.dairy.pasteurized.PasteurizedGamepad

open class MapLayeringSystem<KEY, N : IEnhancedNumericSupplier<Double>, B : IEnhancedBooleanSupplier<B>, GAMEPAD: PasteurizedGamepad<N, B>> (startingLayer: KEY, private val map: Map<KEY, GAMEPAD>) : LayeringSystem<KEY, N, B, GAMEPAD>, Map<KEY, GAMEPAD?> by map {
	@SafeVarargs
	constructor(startingLayer: KEY, vararg entries: Pair<KEY, GAMEPAD>) : this(startingLayer, mutableMapOf(*entries))
	init {
		mapNotNull { it.value }.forEach { attachGamepad(it) }
	}

	override val gamepad: GAMEPAD?
		get() { return this[layer] }

	override var layer = startingLayer
}
