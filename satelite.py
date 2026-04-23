import math
import json
from datetime import datetime, timezone

EARTH_RADIUS_KM = 6_371.0
MU = 398_600.4418


def orbital_period(altitude_km: float) -> float:
    r = EARTH_RADIUS_KM + altitude_km
    return 2 * math.pi * math.sqrt(r**3 / MU) / 60


def orbital_velocity(altitude_km: float) -> float:
    r = EARTH_RADIUS_KM + altitude_km
    return math.sqrt(MU / r) * 3.6


def classify_orbit(altitude_km: float) -> str:
    if altitude_km < 2_000:
        return "LEO"
    if altitude_km < 35_786:
        return "MEO"
    return "GEO"


def satellite_report(name: str, norad_id: str, altitude_km: float) -> dict:
    return {
        "name": name,
        "norad_id": norad_id,
        "altitude_km": altitude_km,
        "orbit_type": classify_orbit(altitude_km),
        "period_min": round(orbital_period(altitude_km), 2),
        "velocity_kmh": round(orbital_velocity(altitude_km), 2),
        "generated_at": datetime.now(timezone.utc).isoformat(),
    }


if __name__ == "__main__":
    satellites = [
        ("SAT-BR-01", "12345", 550.0),
        ("SAT-BR-02", "67890", 1200.0),
        ("SAT-GEO-01", "11111", 35_786.0),
    ]

    for name, norad_id, altitude in satellites:
        report = satellite_report(name, norad_id, altitude)
        print(json.dumps(report, indent=2, ensure_ascii=False))
