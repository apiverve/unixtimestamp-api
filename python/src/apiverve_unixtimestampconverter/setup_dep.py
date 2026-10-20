from setuptools import setup, find_packages

setup(
    name='apiverve_unixtimestampconverter',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Unix Timestamp Converter converts Unix timestamps into formatted dates and parses ISO 8601 strings back into epoch seconds. Responses break down dates into ISO 8601, RFC 2822, simple time strings, and individual calendar components like year, month, and hour.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/unixtimestamp?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
