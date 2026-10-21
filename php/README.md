# Unix Timestamp Converter API - PHP Package

Unix Timestamp Converter converts Unix timestamps into formatted dates and parses ISO 8601 strings back into epoch seconds. Responses break down dates into ISO 8601, RFC 2822, simple time strings, and individual calendar components like year, month, and hour.

## Installation

Install via Composer:

```bash
composer require apiverve/unixtimestamp
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Unixtimestamp\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'timestamp' => '1609459200',
    'format' => 'seconds'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Unixtimestamp\Client;
use APIVerve\Unixtimestamp\Exceptions\APIException;
use APIVerve\Unixtimestamp\Exceptions\ValidationException;

try {
    $response = $client->execute(['timestamp' => '1609459200', 'format' => 'seconds']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "timestamp": 1609459200,
    "timestamp_format": "seconds",
    "iso_8601": "2021-01-01T00:00:00Z",
    "rfc_2822": "Fri, 01 Jan 2021 00:00:00 GMT",
    "date": "1/1/2021",
    "time": "12:00:00 AM",
    "unix_seconds": 1609459200,
    "unix_milliseconds": 1609459200000,
    "year": 2021,
    "month": 1,
    "day": 1,
    "hour": 0,
    "minute": 0,
    "second": 0,
    "day_of_week": "Friday",
    "timezone": "UTC"
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/unixtimestamp?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/unixtimestamp?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/unixtimestamp?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
