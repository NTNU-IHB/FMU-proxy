package no.mechatronics.sfi.fmuproxy

sealed class IntegratorSettings

class EulerIntegrator(
        val stepSize: Double
): IntegratorSettings()

class ClassicalRungeKuttaIntegrator(
        val stepSize: Double
): IntegratorSettings()

class MidPointIntegrator(
        val stepSize: Double
): IntegratorSettings()

class GillIntegrator(
        val stepSize: Double
): IntegratorSettings()

class AdamsBashforthIntegrator(
        val n_steps: Int,
        val min_Step: Double,
        val max_step: Double,
        val scal_absolute_tolerance: Double,
        val scal_relative_tolerance: Double
): IntegratorSettings()

class DormandPrince54Integrator(
        val min_Step: Double,
        val max_step: Double,
        val scal_absolute_tolerance: Double,
        val scal_relative_tolerance: Double
): IntegratorSettings()