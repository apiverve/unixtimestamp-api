using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.UnixTimestampConverter
{
    /// <summary>
    /// Query options for the Unix Timestamp Converter API
    /// </summary>
    public class UnixTimestampConverterQueryOptions
    {
        /// <summary>
        /// Unix timestamp to convert
        /// </summary>
        [JsonProperty("timestamp")]
        public string Timestamp { get; set; }

        /// <summary>
        /// Timestamp format
        /// </summary>
        [JsonProperty("format")]
        public string Format { get; set; }

        /// <summary>
        /// IANA timezone (or fixed UTC offset) to also show the moment in, returned as a local block
        /// </summary>
        [JsonProperty("timezone")]
        public string Timezone { get; set; }
    }
}
