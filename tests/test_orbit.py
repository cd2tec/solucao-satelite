import sys, os
sys.path.insert(0, os.path.join(os.path.dirname(__file__), ".."))

from orbit import classify_orbit, orbital_period, orbital_velocity


def test_classify_leo():
    assert classify_orbit(550) == "LEO"

def test_classify_meo():
    assert classify_orbit(10_000) == "MEO"

def test_classify_geo():
    assert classify_orbit(35_786) == "GEO"

def test_orbital_period_positive():
    assert orbital_period(550) > 0

def test_orbital_velocity_positive():
    assert orbital_velocity(550) > 0

def test_leo_faster_than_geo():
    assert orbital_velocity(550) > orbital_velocity(35_786)
