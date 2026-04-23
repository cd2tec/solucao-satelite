"""
satelite.py — Gerador de relatório de parâmetros orbitais.

Uso:
    python satelite.py
"""

import json
from datetime import datetime, timezone
from orbit import classify_orbit, orbital_period, orbital_velocity


def satellite_report(name: str, norad_id: str, altitude_km: float) -> dict:
    """Gera um dicionário com os parâmetros orbitais calculados para um satélite."""
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
