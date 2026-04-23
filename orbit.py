"""Utilitários de mecânica orbital para satélites artificiais."""

import math

EARTH_RADIUS_KM = 6_371.0
MU = 398_600.4418  # km³/s²


def orbital_period(altitude_km: float) -> float:
    """Retorna o período orbital em minutos para uma dada altitude."""
    r = EARTH_RADIUS_KM + altitude_km
    return 2 * math.pi * math.sqrt(r**3 / MU) / 60


def orbital_velocity(altitude_km: float) -> float:
    """Retorna a velocidade orbital em km/h para uma dada altitude."""
    r = EARTH_RADIUS_KM + altitude_km
    return math.sqrt(MU / r) * 3.6


def classify_orbit(altitude_km: float) -> str:
    """Classifica o tipo de órbita (LEO, MEO ou GEO) pela altitude."""
    if altitude_km < 2_000:
        return "LEO"
    if altitude_km < 35_786:
        return "MEO"
    return "GEO"
